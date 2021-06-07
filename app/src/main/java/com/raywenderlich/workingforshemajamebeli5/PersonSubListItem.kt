package com.raywenderlich.workingforshemajamebeli5


import com.squareup.moshi.Json
import androidx.annotation.Keep

@Keep
data class PersonSubListItem(

    val field_id: Int,

    val fieldType: String,

    val hint: String,

    val icon: String,

    val isActive: Boolean,

    val keyboard: String?,

    val required: String?
)