package com.example.sixmdk.presentations.common.view

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.example.sixmdk.databinding.LayoutSnackbarErrorBinding
import com.google.android.material.snackbar.Snackbar


fun View.showErrorSnackbar(text: String, length: Int = Snackbar.LENGTH_LONG, anchorView: View? = null, action: () -> Unit = {}) {
    val snackbar = Snackbar.make(this, "", length)
    val layoutInflater = LayoutInflater.from(context)

    val errorViewBinding = LayoutSnackbarErrorBinding.inflate(layoutInflater)
    errorViewBinding.text.text = text
    errorViewBinding.icClose.setOnClickListener {
        action()
        snackbar.dismiss()
    }

    snackbar.view.setBackgroundColor(Color.TRANSPARENT)

    val snackbarLayout = snackbar.view as FrameLayout
    snackbarLayout.setPadding(0, 0, 0, 0)

    snackbarLayout.addView(errorViewBinding.root, 0)

    anchorView?.let {
        snackbar.setAnchorView(it)
    }

    snackbar.show()
}
