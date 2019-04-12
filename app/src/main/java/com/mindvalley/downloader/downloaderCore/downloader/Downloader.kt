package com.mindvalley.downloader.downloaderCore.downloader

import com.mindvalley.downloader.downloaderCore.cache.Cache

interface Downloader<T> {
    fun initiateDownload(url: String)
    fun getCache(): Cache<T>
}