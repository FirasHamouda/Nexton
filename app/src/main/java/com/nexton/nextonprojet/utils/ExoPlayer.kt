package com.nexton.nextonprojet.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.nexton.nextonprojet.R
import com.nexton.nextonprojet.utils.URLConstants.Companion.URL_DASH

class ExoPlayer @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : PlayerView(context, attrs, defStyleAttr){

    private val TAG = javaClass.simpleName
    private var playbackPosition: Long = 0


        /**
         * init Exo Player
         */
        fun initPlayer() {
            player = SimpleExoPlayer.Builder(context).build()
            player?.playWhenReady = false
            player?.seekTo(playbackPosition)

            (player as SimpleExoPlayer?)?.prepare(buildMediaSource(), false, false)

            player?.setMediaItem(MediaItem.fromUri(URL_DASH))
            player?.prepare()

            Log.i(TAG, "Exo player is initiated")
        }

        @SuppressLint("InlinedApi")
        fun hideSystemUi() {
            systemUiVisibility = (View.SYSTEM_UI_FLAG_LOW_PROFILE
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
        }


        /**
         * release Exo Player
         */
        fun releasePlayer() {
            player?.release()
            player = null
            Log.i(TAG, "Exo player is released")
        }


        /**
         * build Media Source
         */
        private fun buildMediaSource(): MediaSource {
            val userAgent = Util.getUserAgent(
                context,
                context.getString(R.string.app_name)
            )

            val dataSourceFactory = DefaultHttpDataSourceFactory(userAgent)
            return HlsMediaSource.Factory(dataSourceFactory).
            createMediaSource(Uri.parse(URL_DASH))

        }

}