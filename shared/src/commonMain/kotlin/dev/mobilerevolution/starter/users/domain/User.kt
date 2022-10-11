package dev.mobilerevolution.starter.users.domain

import dev.mobilerevolution.starter.platform.Parcelable
import dev.mobilerevolution.starter.platform.Parcelize

@Parcelize
data class User(
    val id: String,
    val name: String,
) : Parcelable
