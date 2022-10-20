package com.example.weatherapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val msg: String? = null,
    val status: Int? = null,
    val statuscode: Int? = null,
    val token: String? = null,
    val token_type: String? = null,
    val user: UserInfo
)

@Serializable
data class UserInfo(
    val age: String? = null,
    val app_user_type: Int? = null,
    val apple_token: String? = null,
    val avatar: String? = null,
    val business_email: String? = null,
    val business_name: String? = null,
    val country_code: String? = null,
    val created_at: String? = null,
    val dial_code: String?= null,
    val email: String?= null,
    val email_verified_at: String? = null,
    val id: Int? = null,
    val name: String? = null,
    val phone: String? = null,
    val social_id: String? = null,
    val updated_at: String? = null,
    val user_type: Int? = null,
    val username: String? = null
)
