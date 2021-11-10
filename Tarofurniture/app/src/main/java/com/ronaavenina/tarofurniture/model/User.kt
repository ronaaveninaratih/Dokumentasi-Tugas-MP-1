package com.ronaavenina.tarofurniture.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    val name : String,
    val harga : String,
    val desc : String
    ) : Parcelable