package com.mindvalley.downloader.extensions

import android.databinding.BindingAdapter
import android.graphics.Bitmap
import android.widget.ImageView
import com.mindvalley.downloader.downloaderCore.downloader.DownloadCallback
import com.mindvalley.downloader.downloaderCore.downloader.DownloaderProvider

@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(url: String) {
    DownloaderProvider.bitmapDownloader.download(url, object : DownloadCallback<Bitmap> {
        override fun onComplete(file: Bitmap) {
            setImageBitmap(file)
        }

        override fun onError() {
        }
    })
}
