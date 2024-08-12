package com.example.hushh_connect_vone.data

import androidx.compose.runtime.mutableStateListOf

data class UserLiked(
    val imageRes: Int,
    val name: String,
    val role: String,
    val companyName: String,
    val location: String,
    val description: String,
    val profileName: String = "",
    val contactNumber: String = ""
)

object UserLikedManager {
    private val likedUsers = mutableStateListOf<UserLiked>()

    fun addLikedUser(user: UserLiked) {
        likedUsers.add(user)
    }

    fun getLikedUsers(): List<UserLiked> {
        return likedUsers
    }
}
