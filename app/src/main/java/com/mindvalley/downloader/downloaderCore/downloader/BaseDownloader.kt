package com.mindvalley.downloader.downloaderCore.downloader

import io.reactivex.disposables.CompositeDisposable

abstract class BaseDownloader<T>: Downloader<T> {
    private val requestMap: MutableMap<String, MutableList<DownloadCallback<T>>> = mutableMapOf()
    val compositeDisposable = CompositeDisposable()

    fun download(url: String, callback: DownloadCallback<T>){
        var callbacks: MutableList<DownloadCallback<T>>? = requestMap[url]
        if(callbacks == null){
            callbacks = mutableListOf<DownloadCallback<T>>().apply { add(callback) }
            requestMap[url] = callbacks
        }
        else
            callbacks.add(callback)

        val cache = getCache()
        if(cache.fileExistsInCache(url))
            dispatchResult(url, cache.get(url))
        else
            initiateDownload(url)
    }

    fun dispatchResult(url: String, file: T?){
        requestMap[url]?.forEach {
            if(file != null) it.onComplete(file) else it.onError()
        }
        requestMap.remove(url)
    }

    fun cancelRequest(url: String){
        if(requestMap[url] != null)
            requestMap.remove(url)
    }
}