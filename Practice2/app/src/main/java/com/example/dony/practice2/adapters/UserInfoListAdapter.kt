package com.example.dony.practice2.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.dony.practice.adapters.viewholder.SimpleViewHolder
import com.example.dony.practice2.R
import com.example.dony.practice2.models.UserInfoModel
import com.example.dony.practice2.models.UserRepoModel
import com.example.dony.practice2.utils.GlideImageUtil
import kotlinx.android.synthetic.main.list_item_user_info.view.*
import kotlinx.android.synthetic.main.list_item_user_repo.view.*

class UserInfoListAdapter : RecyclerView.Adapter<SimpleViewHolder>() {
    private val userRepos = ArrayList<UserRepoModel>()
    private var userInfoModel = UserInfoModel()

    fun putItems(items: ArrayList<UserRepoModel>, model: UserInfoModel) {
        userInfoModel = model
        userRepos.clear()
        userRepos.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        return SimpleViewHolder(LayoutInflater.from(parent.context).inflate(when (viewType) {
            VIEW_USER_INFO -> R.layout.list_item_user_info
            else -> R.layout.list_item_user_repo
        }, parent, false))
    }

    override fun getItemCount(): Int {
        return userRepos.size
    }

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        holder.itemView.run {
            userRepos[holder.adapterPosition].run {
                if (holder.adapterPosition == 0) {
                    GlideImageUtil.loadImage(context, userInfoModel.avatar_url, img_photo)
                    txt_user_name.text = userInfoModel.login
                } else {
                    txt_repo_name.text = name
                    txt_repo_star_count.text = stargazers_count.toString()
                    txt_repo_description.text = description
                    setOnClickListener { }
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) VIEW_USER_INFO else VIEW_USER_REPO
    }

    companion object {
        private const val VIEW_USER_INFO = 1
        private const val VIEW_USER_REPO = 2
    }
}