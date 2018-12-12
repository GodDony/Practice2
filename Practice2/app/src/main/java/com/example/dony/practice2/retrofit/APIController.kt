package com.example.dony.practice2.retrofit

import android.annotation.SuppressLint
import com.example.dony.practice2.models.UserInfoModel
import com.example.dony.practice2.models.UserRepoModel
import com.example.dony.practice2.retrofit.bases.BaseAPIController
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class APIController : BaseAPIController() {

    /**
     * 유저 정보 가져오기
     */
    fun requestUserInfo(userName: String): Observable<UserInfoModel> {
        return getAPIService().requestUserInfo(userName)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * 유저 저장소 정보 가져오기
     */
    fun requestUserRepo(userName: String): Observable<ArrayList<UserRepoModel>> {
        return getAPIService().requestUserRepo(userName)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    private object Holder {
        @SuppressLint("StaticFieldLeak")
        val INSTANCE = APIController()
    }

    companion object {
        val instance: APIController by lazy { Holder.INSTANCE }
    }
}