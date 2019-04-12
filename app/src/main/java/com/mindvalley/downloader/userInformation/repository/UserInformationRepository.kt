package com.mindvalley.downloader.userInformation.repository

import android.app.Application
import com.mindvalley.downloader.userInformation.api.UserInformationAPI
import com.mindvalley.downloader.downloaderCore.networking.RetrofitProvider
import com.mindvalley.downloader.userInformation.model.UserInformationResponseDTO
import io.reactivex.Single

class UserInformationRepository(val application: Application, val api: UserInformationAPI = RetrofitProvider.createAPI(
    UserInformationAPI::class.java)) {

    fun fetchEventsFromServer(): Single<List<UserInformationResponseDTO>>{
        return api.fetchUserInformation()
    }

}