package com.mindvalley.downloader.userInformation.repository

import android.app.Application
import com.mindvalley.downloader.userInformation.api.UserInformationAPI
import io.reactivex.Single
import org.junit.Test

import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UserInformationRepositoryTest {

    @Mock
    lateinit var api: UserInformationAPI

    lateinit var repository: UserInformationRepository

    @Mock
    lateinit var application: Application

    @Test
    fun fetchEventsFromServer() {
        repository = UserInformationRepository(application, api)
        Mockito.`when`(repository.fetchEventsFromServer()).thenReturn(Single.just(listOf()))
        repository.fetchEventsFromServer().test().assertValue(listOf())
    }
}