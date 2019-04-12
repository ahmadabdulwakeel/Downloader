package com.mindvalley.downloader.downloaderCore.cache

interface Cache<T> {
    fun save( key: String, data: T)
    fun get( key: String): T?
    fun fileExistsInCache(key: String): Boolean
}