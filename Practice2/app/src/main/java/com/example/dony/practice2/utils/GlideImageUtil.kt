package com.example.dony.practice2.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import java.io.File


/**
 * Created by apposter on 2017. 2. 10..
 */
object GlideImageUtil {
    /**
     * 기본 Glide Option 가져오기
     *
     * @return RequestOptions
     */
    private val defaultRequestOptions: RequestOptions
        get() = RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()

    /**
     * 이미지 불러오기
     *
     * @param context   context
     * @param uri       uri
     * @param imageView imageView
     */
    fun loadImage(context: Context, uri: String, imageView: ImageView) {
        try {
            Glide.with(context).load(uri)
                    .apply(defaultRequestOptions)
                    .into(imageView)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
