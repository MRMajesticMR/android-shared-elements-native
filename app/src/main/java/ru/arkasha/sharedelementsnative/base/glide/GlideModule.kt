package ru.arkasha.sharedelementsnative.base.glide

import android.content.Context
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import okhttp3.OkHttpClient
import ru.arkasha.sharedelementsnative.BuildConfig
import java.io.InputStream

@GlideModule
open class GlideModule : AppGlideModule() {

    override fun applyOptions(context: Context, glideBuilder: GlideBuilder) {
        glideBuilder
            .setDefaultRequestOptions(
                RequestOptions()
                    .format(DecodeFormat.PREFER_ARGB_8888)
            )

        if (BuildConfig.DEBUG) {
            glideBuilder.setLogLevel(Log.VERBOSE)
        }
    }

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        val okHttpClientBuilder = OkHttpClient.Builder()

        registry
            .append(
                GlideUrl::class.java,
                InputStream::class.java,
                OkHttpUrlLoader.Factory(okHttpClientBuilder.build())
            )
    }

}