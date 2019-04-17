package com.mindvalley.downloader.userInformation.viewholder

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.mindvalley.test.BR
import com.mindvalley.downloader.userInformation.model.UserInformationResponseDTO


class UserInfoViewHolder(val view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view), View.OnClickListener {
    override fun onClick(v: View?) {
        Toast.makeText(v?.context, itemUserBinding.userInfo?.user?.name, Toast.LENGTH_SHORT).show()
    }

    private lateinit var itemUserBinding: com.mindvalley.test.databinding.ItemUserBinding

    constructor(itemUserBinding: com.mindvalley.test.databinding.ItemUserBinding) : this(itemUserBinding.root) {
        this.itemUserBinding = itemUserBinding
        itemView.setOnClickListener(this)
    }

    fun bind(userInfo: UserInformationResponseDTO) {
        itemUserBinding.setVariable(BR.userInfo, userInfo)
        itemUserBinding.executePendingBindings()

    }
}
