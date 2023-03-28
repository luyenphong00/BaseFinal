package vn.com.ivnd.basefinal.base

import android.annotation.SuppressLint
import android.content.Context
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import java.util.concurrent.Executors

/**
 * Create by phong.luyenthanh
 */
abstract class BaseAdapter<T, BD : ViewBinding>(
    open var context: Context,
    callBack : DiffUtil.ItemCallback<T>
) : ListAdapter<T, BaseViewAppHolder>(AsyncDifferConfig.Builder(callBack)
        .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor()).build())
{

    override fun onBindViewHolder(holder: BaseViewAppHolder, position: Int) {
        val binding = holder.binding as BD
        binding.bindData(getItem(position), position)
    }

    abstract fun BD.bindData(item : T?, position: Int)

    override fun submitList(list: MutableList<T>?) {
        super.submitList(ArrayList<T>(list ?: listOf()))
    }

}

abstract class BaseDiffCallBack<T> : DiffUtil.ItemCallback<T>(){
    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

}

class BaseViewAppHolder(var binding: ViewBinding) :
    RecyclerView.ViewHolder(binding.root)