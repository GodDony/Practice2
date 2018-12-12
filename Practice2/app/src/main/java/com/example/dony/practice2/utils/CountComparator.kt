package com.example.dony.practice2.utils

import com.example.dony.practice2.models.UserRepoModel

class CountComparator : Comparator<UserRepoModel> {
    override fun compare(arg0: UserRepoModel, arg1: UserRepoModel): Int {
        return arg1.stargazers_count.compareTo(arg0.stargazers_count)
    }
}