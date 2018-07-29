package com.example.projeto.projectkotlin.ultis

import android.databinding.BindingAdapter
import android.support.annotation.NonNull
import android.view.View


class ImageViewBinding {
    companion object {

        @BindingAdapter("android:layout_height")
        @JvmStatic
        fun setLayoutHeight(@NonNull view: View, @NonNull height: Number){
            val layoutParams = view.layoutParams
            layoutParams.height = height.toInt()
            view.layoutParams = layoutParams
        }
    }
}