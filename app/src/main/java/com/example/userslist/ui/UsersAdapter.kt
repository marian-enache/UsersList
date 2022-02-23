package com.example.userslist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.userslist.R
import com.example.userslist.databinding.CellUserBinding
import com.example.userslist.domain.User
import com.example.userslist.utils.DateUtils


internal class UsersAdapter(diffCallback: DiffUtil.ItemCallback<User>) :
    PagingDataAdapter<User, UsersAdapter.UserViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding =
            CellUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class UserViewHolder(private val binding: CellUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.apply {
                val context = root.context
                tvName.text = user.getName()
                tvInfo.text = context.getString(
                    R.string.label_years_from,
                    user.getYearsOld(),
                    user.getLocation()
                )
                tvLastRegistration.text = DateUtils.getHourOfDayFromDate(user.getRegisteredAt())

                Glide.with(context)
                    .load(user.getImageUrl())
                    .circleCrop()
                    .placeholder(R.drawable.ic_face_44)
                    .error(R.drawable.ic_face_44)
                    .into(ivProfile)
            }
        }
    }
}