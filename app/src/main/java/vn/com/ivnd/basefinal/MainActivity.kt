package vn.com.ivnd.basefinal

import android.os.Bundle
import vn.com.ivnd.basefinal.base.BaseActivity
import vn.com.ivnd.basefinal.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun injectWithKoin() = loadModules

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}

private val loadModules by lazy {
    //  loadKoinModules(module {
    //        viewModel {
    //            AuthViewModel()
    //        }
    //        viewModel {
    //            LoginViewModel(get(), get())
    //        }
    //        viewModel {
    //            ManagerProfileViewModel(get(),get(), get(), get(), get())
    //        }
    //        viewModel {
    //            RegisterBiometrictAuthViewModel(get())
    //        }
    //        viewModel {
    //            VerifySignatureViewModel(get(), get())
    //        }
    //        viewModel{
    //           UpdateAppViewModel()
    //        }
    //        viewModel{
    //            InformationViewModel(get())
    //        }
    //    })
}