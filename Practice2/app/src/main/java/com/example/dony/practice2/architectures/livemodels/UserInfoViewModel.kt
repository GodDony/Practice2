package com.example.dony.practice2.architectures.livemodels

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import com.example.dony.practice2.architectures.bases.BaseViewModel
import com.example.dony.practice2.models.UserInfoModel
import com.example.dony.practice2.models.UserRepoModel
import com.example.dony.practice2.retrofit.APIController


class UserInfoViewModel : BaseViewModel() {

    val userInfoLiveData = MutableLiveData<UserInfoModel>()
    val userRepoLiveData = MutableLiveData<ArrayList<UserRepoModel>>()

    @SuppressLint("CheckResult")
    fun requestUserInfo(userName: String) {
        APIController.instance.requestUserInfo(userName).subscribe { userInfoLiveData.value = it }
    }

    @SuppressLint("CheckResult")
    fun requestUserRepo(userName: String) {
        APIController.instance.requestUserRepo(userName).subscribe { userRepoLiveData.value = it }
    }
}
