package com.example.jetpackcomposecatalog.model

import androidx.annotation.DrawableRes

data class SuperHero(
    val name: String,
    val realName: String,
    val publisher: String,
    @DrawableRes val image: Int
)
