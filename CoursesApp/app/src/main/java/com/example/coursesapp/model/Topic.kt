package com.example.coursesapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(@StringRes val courseNameId: Int, val courseNumber: Int, @DrawableRes val courseImageId: Int)
