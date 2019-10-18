package com.dt.jetpacksample.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.dt.jetpacksample.BR
import com.dt.jetpacksample.R
import com.dt.jetpacksample.databinding.FragmentHomeBinding
import com.dt.jetpacksample.viewmodel.HomeViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class HomeFragment : Fragment() {

    private lateinit var dataBinding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    @Inject
    lateinit var test: String

    @Inject
    lateinit var viewModelProviders: ViewModelProvider.Factory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelProviders).get(HomeViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        dataBinding.lifecycleOwner = this
        return dataBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("From fragment $$$$$$", test)
        dataBinding.setVariable(BR.viewModel, viewModel)
        dataBinding.executePendingBindings()

        viewModel.testApiDao.getTestListLiveData().observe(this, Observer {
            it?.forEach {
                Log.i("Id %%%%%$###$", "${it.id}  ${it.createdAt}")
            }
        })
    }

}