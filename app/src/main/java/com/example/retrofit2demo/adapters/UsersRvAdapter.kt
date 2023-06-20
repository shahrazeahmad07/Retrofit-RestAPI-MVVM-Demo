package com.example.retrofit2demo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit2demo.R
import com.example.retrofit2demo.model.Data
import com.squareup.picasso.Picasso

class UsersRvAdapter(private val list: List<Data>) : RecyclerView.Adapter<UsersRvAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_singler_user, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val name = "${list[position].first_name} ${list[position].last_name}"
        holder.tvUserName.text = name
        Picasso.get().load(list[position].avatar).into(holder.ivUserAvatar)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivUserAvatar: ImageView
        val tvUserName: TextView
        init {
            ivUserAvatar = itemView.findViewById(R.id.ivUserAvatar)
            tvUserName = itemView.findViewById(R.id.tvUserName)
        }
    }
}