package com.dt.jetpacksample.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dt.jetpacksample.model.TestObj
import com.dt.jetpacksample.repository.TestRepository
import com.dt.jetpacksample.room.dao.TestApiDao
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class HomeViewModel @Inject constructor(name: String, private val testRepository: TestRepository, val testApiDao: TestApiDao) : ViewModel() {


    val mName = MutableLiveData<String>()

    init {
        Log.d("From ViewModel $$$$$$", name)
        mName.value = name
        getList()
    }

    private fun getList() {
        testRepository.getList(object : Observer<List<TestObj>> {
            override fun onComplete() {
                //hide loading````
            }

            override fun onSubscribe(d: Disposable) {
                //show loading
            }

            override fun onNext(t: List<TestObj>) {
                //hide loading````
                if(t.isNotEmpty()){
                    testApiDao.deleteAll()
                    testApiDao.saveTestList(t)
                }
                // result
            }

            override fun onError(e: Throwable) {
                //hide loading````
            }

        })
    }

}