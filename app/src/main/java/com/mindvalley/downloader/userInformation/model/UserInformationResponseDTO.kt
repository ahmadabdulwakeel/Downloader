package com.mindvalley.downloader.userInformation.model

data class UserInformationResponseDTO(
    val id: String,
    val width: Int,
    val height: Int,
    val color: String,
    val likes: Int,
    val liked_by_user: Boolean,
    val user: User,
    val urls: Urls,
    val categories: List<Category>,
    val links: Link
)