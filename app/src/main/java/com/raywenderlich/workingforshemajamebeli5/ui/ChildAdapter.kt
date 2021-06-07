package com.raywenderlich.workingforshemajamebeli5.ui


import android.text.Editable
import android.text.TextWatcher
import android.util.Log.d
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.set
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.workingforshemajamebeli5.PersonSubListItem
import com.raywenderlich.workingforshemajamebeli5.databinding.ChildItemBinding
import org.w3c.dom.Text
import kotlin.math.log

class ChildAdapter(private val childData: List<PersonSubListItem>):RecyclerView.Adapter<ChildAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildAdapter.ViewHolder {
        return ViewHolder(ChildItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ChildAdapter.ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount()= childData.size





    inner class ViewHolder(private val binding: ChildItemBinding):RecyclerView.ViewHolder(binding.root),TextWatcher{

        fun bind(){

            binding.editTextDataHint.addTextChangedListener(this)
            binding.editTextDataHint.hint = childData[adapterPosition].hint

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(s: Editable?) {

        }

    }


}