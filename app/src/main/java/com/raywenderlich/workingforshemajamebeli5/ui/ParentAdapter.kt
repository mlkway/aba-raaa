package com.raywenderlich.workingforshemajamebeli5.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.children
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.workingforshemajamebeli5.PersonSubListItem
import com.raywenderlich.workingforshemajamebeli5.databinding.ParentItemBinding
import kotlin.coroutines.coroutineContext

class ParentAdapter:RecyclerView.Adapter<ParentAdapter.ViewHolder>() {

    private  lateinit var childAdapter: ChildAdapter



    var arrData: List<List<PersonSubListItem>> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentAdapter.ViewHolder {
        return ViewHolder(ParentItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }



    override fun onBindViewHolder(holder: ParentAdapter.ViewHolder, position: Int) {
        holder.binding.parenRecyclerview.layoutManager = GridLayoutManager(holder.itemView.context,1)
        childAdapter = ChildAdapter(arrData[position])
        holder.binding.parenRecyclerview.adapter = childAdapter

    }

    override fun getItemCount() = arrData.size

    inner class ViewHolder(val binding: ParentItemBinding):RecyclerView.ViewHolder(binding.root){



    }





}
