package vn.com.ivnd.basefinal.base

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.view.WindowManager
import vn.com.ivnd.basefinal.R

class VndLoading : Dialog {
    constructor(context: Context, layout: Int?) : super(context) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.layout_loading)
        window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val lp = window?.attributes
        lp?.width = WindowManager.LayoutParams.MATCH_PARENT
        lp?.height = WindowManager.LayoutParams.MATCH_PARENT
        setCancelable(false)
        setCanceledOnTouchOutside(false)
    }

    private fun setAllowTouchParentView(isAllowTouchParentView: Boolean) {
        if (isAllowTouchParentView) {
            window?.setFlags(
                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
            )
        } else {
            window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL)
        }
    }

    override fun show() {
        if (!isShowing) {
            super.show()
        }
    }

    fun show(isAllowTouchParentView: Boolean) {
        if (isAllowTouchParentView) {
            setAllowTouchParentView(isAllowTouchParentView)
        } else {
            setAllowTouchParentView(isAllowTouchParentView)
        }
        show()
    }


}