package vn.com.ivnd.basefinal.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

open abstract class BaseActivity<VB : ViewBinding>(val bindingFactory: (LayoutInflater) -> VB) : AppCompatActivity() {

    protected lateinit var binding: VB

    abstract fun injectWithKoin()
    override fun onCreate(savedInstanceState: Bundle?) {
        injectWithKoin()
        super.onCreate(savedInstanceState)
        binding = bindingFactory(layoutInflater)
        setContentView(binding.root)
    }
}