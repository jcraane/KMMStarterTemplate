package com.example.kmmtest.users.domain

import com.example.kmmtest.platform.Parcelable
import com.example.kmmtest.platform.Parcelize

@Parcelize
data class User(val name: String) : Parcelable
