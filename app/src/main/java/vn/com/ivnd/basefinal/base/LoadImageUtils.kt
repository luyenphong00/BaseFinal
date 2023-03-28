package vn.com.ivnd.basefinal.base

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import de.hdodenhof.circleimageview.CircleImageView

/**
 * Create by phong.luyenthanh
 */

/**
 * function loading image
 */
fun View.loadImage(context : Context, url : String, onLoadingSuccess : () -> Unit?, imageError : Int){
    when (this) {
        is ImageView -> {
            Glide.with(context).load(url).diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .listener(onListenerLoadingImage {
                    onLoadingSuccess.invoke()
                }).into(this)
        }
        is CircleImageView -> {
            Glide.with(context).load(url).diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .listener(onListenerLoadingImage {
                    onLoadingSuccess.invoke()
                }).into(this)
        }
        is AppCompatImageView -> {
            Glide.with(context).load(url).diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .listener(onListenerLoadingImage {
                    onLoadingSuccess.invoke()
                }).error(imageError).into(this)
        }
    }
}

class onListenerLoadingImage(var onLoadingSuccess : () -> Unit?) : RequestListener<Drawable> {
    override fun onLoadFailed(
        e: GlideException?,
        model: Any?,
        target: Target<Drawable>?,
        isFirstResource: Boolean
    ): Boolean {
        onLoadingSuccess.invoke()
        return false
    }

    override fun onResourceReady(
        resource: Drawable?,
        model: Any?,
        target: Target<Drawable>?,
        dataSource: DataSource?,
        isFirstResource: Boolean
    ): Boolean {
        onLoadingSuccess.invoke()
        return false
    }
}