package com.mindvalley.downloader.userInformation.api

import com.mindvalley.downloader.userInformation.model.UserInformationResponseDTO
import io.reactivex.Single
import retrofit2.http.GET

interface UserInformationAPI {
    @GET( "raw/wgkJgazE")
    fun fetchUserInformation( ): Single<List<UserInformationResponseDTO>>
}