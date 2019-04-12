package com.mindvalley.downloader.userInformation.adapter

import android.databinding.DataBindingUtil
import android.support.annotation.NonNull
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mindvalley.test.R
import com.mindvalley.downloader.userInformation.model.UserInformationResponseDTO
import com.mindvalley.downloader.userInformation.viewholder.UserInfoViewHolder

class UserInformationAdapter( ) : ListAdapter<UserInformationResponseDTO, UserInfoViewHolder>(diffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserInfoViewHolder {
        val itemUserBinding = DataBindingUtil.inflate<com.mindvalley.test.databinding.ItemUserBinding>(LayoutInflater.from(parent.context), R.layout.item_user, parent, false)
        return UserInfoViewHolder(itemUserBinding)
    }


    override fun onBindViewHolder(holder: UserInfoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {

        val diffUtilCallback = object : DiffUtil.ItemCallback<UserInformationResponseDTO>() {
            override fun areItemsTheSame(p0: UserInformationResponseDTO, p1: UserInformationResponseDTO): Boolean {
                return p0.id == p1.id
            }

            override fun areContentsTheSame(p0: UserInformationResponseDTO, p1: UserInformationResponseDTO): Boolean {
                return true
            }

        }
    }
}

