package com.raywenderlich.workingforshemajamebeli5.ui

import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.children
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.workingforshemajamebeli5.PersonSubListItem
import com.raywenderlich.workingforshemajamebeli5.R
import com.raywenderlich.workingforshemajamebeli5.databinding.ScreenFragmentBinding

class ScreenFragment : Fragment() {


    private lateinit var binding: ScreenFragmentBinding



    private val viewModel by viewModels<ScreenViewModel>()


    private lateinit var parentAdapter: ParentAdapter




    var personData = mutableMapOf<Int, String>()

    private var data : List<List<PersonSubListItem>> = emptyList()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ScreenFragmentBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initParent()


        viewModel.personData.observe(viewLifecycleOwner,{
            parentAdapter.arrData = it
            data = it

        })




        binding.register.setOnClickListener{
            binding.mainRecyclerview.children.forEach { it ->
                it.findViewById<RecyclerView>(R.id.parenRecyclerview).children.forEach {
                    var editext = it.findViewById<EditText>(R.id.editTextDataHint)
                    var hint = editext.hint.toString()
                    var value = editext.text.toString()
                    var key = data.checkFieldId(hint)
                    if (value.isEmpty()&& data.checkRequired(key)){

                        Toast.makeText(context,"fill $hint",Toast.LENGTH_SHORT).show()
                    }else{
                        personData[key] = value
                    }


                }

            }
            d("tag", "${personData.keys} and ${personData.values}")


        }



    }



    private fun List<List<PersonSubListItem>>.checkRequired(id: Int):Boolean{
        var bool = true
        for (i in this){
            for (j in i){
                if (j.field_id == id){
                    bool = j.required.toBoolean()
                }
            }
        }
        return bool
    }


    private fun List<List<PersonSubListItem>>.checkFieldId(text: String):Int{
        var key = 3
        for (i in this){

          for (j in i){
              if (j.hint == text){
                  key = j.field_id
              }
          }

        }
        return key
    }







    private fun initParent(){
        binding.mainRecyclerview.layoutManager = GridLayoutManager(context,1)
        parentAdapter = ParentAdapter()
        binding.mainRecyclerview.adapter = parentAdapter

    }








}