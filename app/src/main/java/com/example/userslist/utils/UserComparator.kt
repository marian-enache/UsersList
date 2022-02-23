package com.example.userslist.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.userslist.domain.User

object UserComparator : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.getName() == newItem.getName() // Would use the id in a normal app
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}