package com.example.hushh_connect_vone.data

data class ProductData(
    val productImageRes: Int,
    val productName: String,
    val productDescription: String,
    val productPrice: String
)

data class ImageData(
    val imageRes: Int,
    val name: String,
    val role: String,
    val companyName: String,
    val location: String,
    val description: String,
    val fullDescription: String,
    val experience: List<ExperienceData> = emptyList(),
    val products: List<ProductData> = emptyList()
)

data class ExperienceData(
    val duration: String,
    val company: String,
    val location: String,
    val description: String
)
