package com.swancodes.foodco.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Food(
    @DrawableRes val imageResourceId: Int,
    val name: String,
    val price: String,
    @StringRes val details: Int,
) : Parcelable
