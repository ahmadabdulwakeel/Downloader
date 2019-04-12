package com.mindvalley.downloader.downloaderCore.downloader

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.mindvalley.downloader.downloaderCore.api.DownloadAPI
import com.mindvalley.downloader.downloaderCore.cache.Cache
import com.mindvalley.downloader.downloaderCore.cache.MindValleyCache
import com.mindvalley.downloader.downloaderCore.networking.RetrofitProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


object BitmapDownloader: BaseDownloader<Bitmap>() {
    override fun getCache(): Cache<Bitmap> {
        return MindValleyCache.bitmapCache
    }

    @SuppressLint("CheckResult")
    override fun initiateDownload(url: String) {
        RetrofitProvider.createAPI(DownloadAPI::class.java).download(url).observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io()).subscribe({
                val bitmap = BitmapFactory.decodeStream(it.byteStream())
                MindValleyCache.bitmapCache.save(url, bitmap)
                dispatchResult(url, bitmap)
            }, {
                dispatchResult(url, null)
            })
    }
}