package com.dt.jetpacksample.api

import com.dt.jetpacksample.model.TestObj
import io.reactivex.Observable
import retrofit2.http.GET

interface JetPackApi {

    @GET("wgkJgazE")
    fun getList(): Observable<List<TestObj>>


}