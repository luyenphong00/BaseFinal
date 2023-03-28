package vn.com.ivnd.basefinal.base

import android.os.Bundle
import androidx.viewbinding.ViewBinding

interface IScreen<VB : ViewBinding> {
    var _binding : VB?
    fun VB.initData()
    fun VB.initObserver()

    fun init(savedInstanceState: Bundle?) {
        _binding?.initView(savedInstanceState)
        _binding?.initData()
        _binding?.initObserver()
        _binding?.initListener()
    }

    fun VB.initView(savedInstanceState: Bundle?) {}

    fun VB.initListener() {}

    object DataResultKey {
        const val IS_CHANGE_TOKEN = "IS_CHANGE_TOKEN"
    }
}