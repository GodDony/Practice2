package com.example.dony.practice2.retrofit

import com.example.dony.practice2.models.UserInfoModel
import com.example.dony.practice2.models.UserRepoModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {
    @GET(APIConsts.PATH_USER_INFO)
    fun requestUserInfo(@Path("username") username: String): Observable<UserInfoModel>

    @GET(APIConsts.PATH_USER_REPO)
    fun requestUserRepo(@Path("username") username: String): Observable<ArrayList<UserRepoModel>>
}