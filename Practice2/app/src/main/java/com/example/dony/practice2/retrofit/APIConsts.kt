package com.example.dony.practice2.retrofit

object APIConsts{
    const val BASE_URL = "https://api.github.com"
    const val PATH_USER_INFO = "$BASE_URL/users/{username}"
    const val PATH_USER_REPO = "$BASE_URL/users/{username}/repos"
}
