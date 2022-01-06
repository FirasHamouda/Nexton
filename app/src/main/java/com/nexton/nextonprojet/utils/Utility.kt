package com.nexton.nextonprojet.utils

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.nexton.nextonprojet.R

object Utility {

    /**
     * Hide the keyBoard
     */
    fun hideKeyboard(view: View) {
        val imm =
            view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }


    /**
     * Bottom Sheet View
     */
    fun showBottomSheet(
        context: Context,
        title: String,
        pitch: String,
        imageURL: String,
        availability: String
    ): BottomSheetDialog {


        val url = URLConstants.BASE_URL

        val dialog = BottomSheetDialog(context)
        val bottomSheetView = View.inflate(context, R.layout.dialog_bottom_sheet, null)

        val titleText = bottomSheetView.findViewById<TextView>(R.id.dialog_episode_title)
        val pitchText = bottomSheetView.findViewById<TextView>(R.id.dialog_pitch)
        val availabilityText = bottomSheetView.findViewById<TextView>(R.id.dialog_availability)
        val imageEpisode = bottomSheetView.findViewById<ImageView>(R.id.dialog_img_episode)

        titleText.text = title
        pitchText.text = pitch
        availabilityText.text = availability
        Glide.with(context)
            .load(url + imageURL)
            .into(imageEpisode)


        dialog.setContentView(bottomSheetView)
        (bottomSheetView.parent as View).setBackgroundColor(Color.TRANSPARENT)
        dialog.show()

        return dialog
    }

}