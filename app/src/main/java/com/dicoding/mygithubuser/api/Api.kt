package com.dicoding.mygithubuser.api

import com.dicoding.mygithubuser.BuildConfig
import com.dicoding.mygithubuser.data.model.DetailUserResponse
import com.dicoding.mygithubuser.data.model.User
import com.dicoding.mygithubuser.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization: token " + BuildConfig.KEY)
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization: token " + BuildConfig.KEY)
    fun getUserDetail(
        @Path("username") username: String
    ): Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token " + BuildConfig.KEY)
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token " + BuildConfig.KEY)
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<User>>
}