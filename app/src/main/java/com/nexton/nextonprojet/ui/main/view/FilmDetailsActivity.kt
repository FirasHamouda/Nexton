package com.nexton.nextonprojet.ui.main.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.nexton.nextonprojet.R
import com.nexton.nextonprojet.data.api.ApiHelper
import com.nexton.nextonprojet.data.api.ApiServiceImpl
import com.nexton.nextonprojet.data.base.ViewModelFactory
import com.nexton.nextonprojet.data.model.Contents
import com.nexton.nextonprojet.data.model.Episodes
import com.nexton.nextonprojet.databinding.ActivityFilmDetailsBinding
import com.nexton.nextonprojet.ui.main.adapter.EpisodeAdapter
import com.nexton.nextonprojet.ui.main.viewmodel.MainViewModel
import com.nexton.nextonprojet.utils.Constants
import com.nexton.nextonprojet.utils.Status
import com.nexton.nextonprojet.utils.Utility


class FilmDetailsActivity : AppCompatActivity() {

    private lateinit var detailLink: String
    private lateinit var imgLarge: String
    private lateinit var details: String
    private lateinit var tvName: String

    private lateinit var toolbar: Toolbar
    private lateinit var collapsingToolbarLayout: CollapsingToolbarLayout


    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var myAdapter: RecyclerView.Adapter<*>

    private lateinit var listEpisode: List<Episodes>

    private lateinit var mainViewModel: MainViewModel

    private val TAG = javaClass.simpleName

    private lateinit var mBinding: ActivityFilmDetailsBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            mBinding = DataBindingUtil.setContentView(this, R.layout.activity_film_details)

            init()

        }

        /**
         * init method
         */
        fun init()
        {
            initBinding()
            setupViewModel()
            setupDetailsObserver()
            initLiveData()
            initEvent()
        }

        /**
         * onBackPressed for navigation
         */
        override fun onSupportNavigateUp(): Boolean {
            onBackPressed()
            return true
        }



        /**
         * init Live Data
         */
        fun initLiveData() {
            mainViewModel.fetchDetail(detailLink)
        }

        /**
         * setUp Observer
         */
         fun setupDetailsObserver() {
            mainViewModel.contentsLiveData.observe(this, Observer {
                when (it.status) {
                    Status.SUCCESS -> {
                        it.data?.let { contents -> renderSeasonList(contents.contents) }
                    }
                    Status.LOADING -> {
                        //Handle LOADING
                    }
                    Status.ERROR -> {
                        //Handle Error
                        Toast.makeText(this, getString(R.string.errorWebService), Toast.LENGTH_LONG).show()
                    }
                }
            })
        }

        /**
         * init Binding the view
         */
        fun initBinding() {

            val bundle = intent.extras

            tvName = bundle?.getString(Constants.NAME).toString()
            details = bundle?.getString(Constants.DESCRIPTION).toString()
            imgLarge = bundle?.getString(Constants.IMAGE).toString()
            detailLink = bundle?.getString(Constants.DETAILLINK).toString()

            if (imgLarge.isNotEmpty()) {
                Glide.with(this)
                    .load(imgLarge)
                    .into(mBinding.tvShowPreview)
            } else {
                mBinding.tvShowPreview.setBackgroundResource(R.drawable.img_no_film)
            }


            mBinding.tvName.text = tvName
            mBinding.tvDetails.text = details

            //Collapsing toolbar
            toolbar = findViewById(R.id.toolbar)
            collapsingToolbarLayout = findViewById(R.id.collapseLayout)
            setSupportActionBar(toolbar)

            var isShow = true
            var scrollRange = -1
            mBinding.mAppBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { barLayout, verticalOffset ->
                if (scrollRange == -1) {
                    scrollRange = barLayout?.totalScrollRange!!
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.title = tvName
                    isShow = true
                } else if (isShow) {
                    collapsingToolbarLayout.title = Constants.SPACE
                    isShow = false
                }
            })

            val actionBar = supportActionBar
            actionBar?.setDisplayHomeAsUpEnabled(true)
        }


        /**
         * init view Event
         */
        fun initEvent() {

            //manage video visibility
            mBinding.mAppBar.setOnClickListener {
                manageVisibility()
                mBinding.playerView.player?.playWhenReady = true
                Log.i(TAG, "Video container is clicked")
            }
        }

        /**
         * manage UI Visibility
         */
        fun manageVisibility() {
            mBinding.playerView.visibility = View.VISIBLE
            mBinding.tvShowPreview.visibility = View.GONE
            mBinding.exoPlayed.visibility = View.GONE
        }

        /**
         * setUp ViewModel
         */
        fun setupViewModel() {
            mainViewModel = ViewModelProviders.of(
                this,
                ViewModelFactory(ApiHelper(ApiServiceImpl()))
            ).get(MainViewModel::class.java)
        }


        /**
         * retrive date from WS response
         */
        private fun renderSeasonList(@Nullable contents: Contents) {

            Log.i(TAG, "Contents : $contents")

            if (contents.pitch.isNullOrEmpty()) {
                mBinding.tvPitch.text = contents.seasons[0].pitch
                listEpisode = contents.seasons[0].episodes

                initRecycler()
            } else {
                mBinding.tvPitch.text = contents.pitch
            }
        }

        /**
         * init the horizontal recycler view for the serie's episodes
         */
        private fun initRecycler() {

            manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            mBinding.recyclerEpisode.apply {
                myAdapter = EpisodeAdapter(listEpisode) { position -> onListItemClick(position) }
                layoutManager = manager
                adapter = myAdapter
            }
        }

        /**
         * Hundle the item click
         */
        private fun onListItemClick(position: Int) {
            Utility.showBottomSheet(
                this,
                getString(R.string.episode) +Constants.SPACE+ listEpisode[position].number + Constants.TWO_POINT +Constants.SPACE+ listEpisode[position].title[0].value,
                listEpisode[position].pitch,
                listEpisode[position].imageurl,
                listEpisode[position].availability[1].value + Constants.JOURS
            )

            Log.i(TAG, "Item is clicked at position ${position}")
        }

        override fun onResume() {
            super.onResume()
            mBinding.playerView.hideSystemUi()
                mBinding.playerView.initPlayer()
                  Log.i(TAG, "onResume")
        }

        override fun onPause() {
            super.onPause()
                mBinding.playerView.releasePlayer()
                 Log.i(TAG, "onPause")
        }

        override fun onStop() {
            super.onStop()
                mBinding.playerView.releasePlayer()
                Log.i(TAG, "onStop")
        }

        /**
         * Manage the focus on video player
         */
        override fun onWindowFocusChanged(hasFocus: Boolean) {
            super.onWindowFocusChanged(hasFocus)
            if (hasFocus) {
                mBinding.playerView.hideSystemUi()
            }
        }
}