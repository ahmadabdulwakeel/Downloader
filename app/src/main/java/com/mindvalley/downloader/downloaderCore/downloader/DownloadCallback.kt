package com.mindvalley.downloader.downloaderCore.downloader

interface DownloadCallback<T> {
    fun onComplete(file: T)
    fun onError()
}