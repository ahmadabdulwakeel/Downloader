package com.mindvalley.downloader.downloaderCore.cache

import android.graphics.Bitmap
import android.support.v4.util.LruCache

object BitmapCache: Cache<Bitmap> {
    private var bitmapCache: LruCache<String, Bitmap>

    init {
        val maxMemory = (Runtime.getRuntime().maxMemory() / 1024).toInt()
        // Use 1/8th of the available memory for this memory cache.
        val cacheSize = maxMemory / 8
        bitmapCache = object : LruCache<String, Bitmap>(cacheSize) {

            override fun sizeOf(key: String, bitmap: Bitmap): Int {
                return bitmap.byteCount / 1024
            }
        }
    }

    override fun save(key: String, data: Bitmap) {
        bitmapCache.put(key, data)
    }

    override fun get(key: String): Bitmap? {
        return bitmapCache[key]
    }

    override fun fileExistsInCache(keyPath: String): Boolean = bitmapCache[keyPath] != null

}