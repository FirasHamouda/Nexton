package com.nexton.nextonprojet.ui.main.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nexton.nextonprojet.R
import com.nexton.nextonprojet.data.model.Episodes
import com.nexton.nextonprojet.databinding.ActivityFilmDetailsBinding
import com.nexton.nextonprojet.utils.URLConstants

class EpisodeAdapter (private val listEpisode: List<Episodes>,private val onItemClicked: (position: Int) -> Unit) : RecyclerView.Adapter<EpisodeAdapter.MyViewHolder>() {



    class MyViewHolder(private val view: View, private val onItemClicked: (position: Int) -> Unit) : RecyclerView.ViewHolder(view),
        View.OnClickListener {

        private val TAG = javaClass.simpleName

        fun bind(episodes: Episodes){

             val url = URLConstants.BASE_URL

            val mEpisode: ImageView = view.findViewById(R.id.img_episode)
            val mNumEpisode: TextView = view.findViewById(R.id.num_episode)
            val mTitleEpisode: TextView = view.findViewById(R.id.title_episode)
            val mPitchEpisode: TextView = view.findViewById(R.id.pitch_episode)

            mNumEpisode.text = episodes.number.toString()
            mTitleEpisode.text = episodes.title[0].value
            mPitchEpisode.text = episodes.pitch

            Glide.with(view.context)
                    .load(url + episodes.imageurl)
                    .into(mEpisode) }

            init {
                view.setOnClickListener(this)
            }

            override fun onClick(v: View) {
                val position = adapterPosition
                onItemClicked(position)

                Log.i(TAG, "Item is clicked at position $position")
            }


    }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.episode_recycler_row, parent, false)
            return MyViewHolder(v, onItemClicked)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.bind(listEpisode[position])
        }

        override fun getItemCount(): Int {
           return listEpisode.size
        }


}