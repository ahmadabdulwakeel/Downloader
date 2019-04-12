package com.mindvalley.downloader.userInformation.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.MutableLiveData
import com.mindvalley.downloader.base.mvvm.BaseViewModel
import com.mindvalley.downloader.userInformation.model.UserInformationResponseDTO
import com.mindvalley.downloader.userInformation.repository.UserInformationRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class UserInformationViewModel(application: Application) : BaseViewModel(application) {
    val userInformationLiveData: MutableLiveData<List<UserInformationResponseDTO>> = MutableLiveData()
    private val userInformationRepository: UserInformationRepository = UserInformationRepository(application)

    @SuppressLint("CheckResult")
    fun fetchUserInformation(){
        userInformationRepository.fetchEventsFromServer().observeOn(AndroidSchedulers.mainThread()).
            subscribeOn(Schedulers.io()).subscribe(Consumer {
            userInformationLiveData.postValue(it)
        })
    }
}
