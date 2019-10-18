package com.dt.jetpacksample.repository

import com.dt.jetpacksample.api.JetPackApi
import com.dt.jetpacksample.model.TestObj
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class TestRepository(val jetPackApi: JetPackApi) {

    fun getList(param: Observer<List<TestObj>>) {

        jetPackApi.getList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(param)
    }


}