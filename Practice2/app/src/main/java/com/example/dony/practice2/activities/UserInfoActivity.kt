package com.example.dony.practice2.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.dony.practice2.R
import com.example.dony.practice2.adapters.UserInfoListAdapter
import com.example.dony.practice2.architectures.livemodels.UserInfoViewModel
import com.example.dony.practice2.models.UserInfoModel
import com.example.dony.practice2.utils.CountComparator
import kotlinx.android.synthetic.main.activity_user_info.*
import java.util.*

class UserInfoActivity : AppCompatActivity() {
    private lateinit var userInfoViewModel: UserInfoViewModel
    private var userInfoModel: UserInfoModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)
        userInfoViewModel = ViewModelProviders.of(this).get(UserInfoViewModel::class.java).apply {
            userInfoLiveData.observe(this@UserInfoActivity, Observer {
                it?.run {
                    userInfoModel = this
                    requestUserRepo(login)
                }
            })

            userRepoLiveData.observe(this@UserInfoActivity, Observer {
                refresh_layout.isRefreshing = false
                it?.run {
                    userInfoModel?.let { userModel ->
                        Collections.sort(this, CountComparator())
                        (recycler_view.adapter as UserInfoListAdapter).putItems(this, userModel)
                    }
                }
            })
            requestUserInfo("jakewharton")
        }
        refresh_layout.setOnRefreshListener { userInfoViewModel.requestUserInfo("jakewharton") }

        recycler_view.run {
            adapter = UserInfoListAdapter()
        }
    }
}
