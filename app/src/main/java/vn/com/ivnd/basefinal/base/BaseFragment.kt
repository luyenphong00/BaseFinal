package vn.com.ivnd.basefinal.base

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.google.android.material.textfield.TextInputLayout
import vn.com.ivnd.basefinal.R

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel>(private val inflate: Inflate<VB>) : Fragment(),
    IScreen<VB> {

    protected abstract val viewModel: BaseViewModel
    lateinit var loading: VndLoading

    override var _binding: VB? = null
    val binding get() = _binding!!

    lateinit var rootView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        loading = VndLoading(requireContext(),
            R.layout.layout_loading)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.rootView = view
        init(savedInstanceState)
        setOnTouchForAllView(view)
    }

    override fun VB.initData() {
    }

    override fun VB.initListener() {

    }

    override fun VB.initObserver() {

    }

    override fun VB.initView(savedInstanceState: Bundle?) {

    }

    private fun setOnTouchForAllView(view: View) {
        if (view !is EditText && view !is TextInputLayout) {
            setEndEdittingWhenTouched(view)
        }
        if (view is ViewGroup) {
            val childCount = view.childCount
            for (i in 0 until childCount) {
                setOnTouchForAllView(view.getChildAt(i))
            }
        }
    }

    private fun clearFocusAllView(view: View) {
        if (view is EditText || view is TextInputLayout) {
            view.clearFocus()
        }
        if (view is ViewGroup) {
            val childCount = view.childCount
            for (i in 0 until childCount) {
                clearFocusAllView(view.getChildAt(i))
            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    open fun setEndEdittingWhenTouched(view: View) {
        view.setOnTouchListener { v, _ ->
            KeyboardUtils.hideKeyboardFrom(context, v)
            clearFocusAllView(rootView!!)
            false
        }
    }

    protected fun getErrorMessFromErrorCode(errorCode: String) : String {
        return if (errorCode.isNotEmpty()) {
            val id = context?.resources?.getIdentifier(
                errorCode.replace("-", "_"),
                "string",
                context?.packageName
            )
            if (id != null) {
                try {
                    getString(id)
                } catch (e: Resources.NotFoundException) {
                    ""
                }
            } else {
                ""
            }
        } else {
            ""
        }
    }


}