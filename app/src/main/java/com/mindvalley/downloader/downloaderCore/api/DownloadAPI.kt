package com.mindvalley.downloader.downloaderCore.api

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Url

interface DownloadAPI {
    @GET
    fun download( @Url url : String): Single<ResponseBody>
}