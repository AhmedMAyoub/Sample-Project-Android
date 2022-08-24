package com.example.sampleprojectayoub

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sampleprojectayoub.databinding.LayoutRvUserSearchBinding
import com.example.sampleprojectayoub.model.User

class MainAdapter : RecyclerView.Adapter<UsersListViewHolder>() {

    var users = mutableListOf<User>()

    fun setUsersList(users: List<User>) {
        this.users = users.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersListViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = LayoutRvUserSearchBinding.inflate(inflater, parent, false)
        return UsersListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsersListViewHolder, position: Int) {
        val user = users[position]
        holder.binding.userLogin.text = user.login
        Glide.with(holder.itemView.context).load(user.avatarUrl)    // TODO: Change it to placeholder
            .into(holder.binding.userAvatar)

    }

    override fun getItemCount(): Int {
        return users.size
    }
}
