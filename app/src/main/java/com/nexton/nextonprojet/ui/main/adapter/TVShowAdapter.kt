package com.nexton.nextonprojet.ui.main.adapter

import android.app.Activity
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.nexton.nextonprojet.R
import com.nexton.nextonprojet.data.model.ProgrammeTvItems
import com.nexton.nextonprojet.ui.main.view.FilmDetailsActivity
import com.nexton.nextonprojet.utils.Constants
import com.nexton.nextonprojet.utils.URLConstants.Companion.BASE_URL


class TVShowAdapter(private var mTvShowList: ArrayList<ProgrammeTvItems>, var activity: Activity) : BaseAdapter(){

    lateinit var sharedPrefs : SharedPreferences

    private val url = BASE_URL

    private val TAG = javaClass.simpleName

    override fun getCount(): Int {
        return mTvShowList.size
    }

    override fun getItem(position: Int): Any {
        return mTvShowList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view : View = View.inflate(activity, R.layout.grid_row, null)


        val txtFilm = view.findViewById<TextView>(R.id.title_film)
        val txtSubTitle = view.findViewById<TextView>(R.id.sub_title_film)
        val imgFilm = view.findViewById<ImageView>(R.id.img_film)

        txtFilm.text = mTvShowList[position].title[0].value
        txtSubTitle.text = mTvShowList[position].subtitle
        Glide.with(activity)
            .load(url + mTvShowList[position].imageurl)
            .into(imgFilm)


        view.setOnClickListener {

            Log.i(TAG, "Item is clicked")

            val intent = Intent(activity, FilmDetailsActivity::class.java)
            intent.putExtra(Constants.NAME, mTvShowList[position].title[0].value)
            intent.putExtra(Constants.DESCRIPTION, mTvShowList[position].subtitle)
            intent.putExtra(Constants.IMAGE, url + mTvShowList[position].fullscreenimageurl)
            intent.putExtra(Constants.DETAILLINK, mTvShowList[position].detaillink)
            activity.startActivity(intent)

            //save title into shared Prefs
            sharedPrefs = activity.getSharedPreferences(Constants.SHAREDPREFS , Context.MODE_PRIVATE)
            val editor = sharedPrefs.edit()
            editor?.putString(Constants.SHAREDPREFS, mTvShowList[position].title[0].value)
            editor?.apply()


            Log.i(TAG, "Title "+mTvShowList[position].title[0].value+" saved in sahred Preferences")

        }

        return view
    }

        /**
         * Set data into the list
         */
        fun setData(list: List<ProgrammeTvItems>) {
            mTvShowList.clear()
            mTvShowList.addAll(list)
            notifyDataSetChanged()

            Log.i(TAG, "TV show list : $mTvShowList")

        }
}