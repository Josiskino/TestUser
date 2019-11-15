package com.josuelassey.testuser.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.josuelassey.testuser.R
import com.josuelassey.testuser.remote_model.PostUser

class AdapterDetailsPostUser(
   private val context : Context,
   private var postList: List<PostUser>
) : RecyclerView.Adapter<AdapterDetailsPostUser.ViewHolderDetailsPostUser>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderDetailsPostUser {
        return ViewHolderDetailsPostUser(LayoutInflater.from(context).inflate(R.layout.details_post_user, parent, false))
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: ViewHolderDetailsPostUser, position: Int) {
        var posts = postList[position]
        holder.userName.text = posts.userId.toString()
        holder.titlePost.text = posts.title
        holder.bodyPost.text = posts.body
    }

    class ViewHolderDetailsPostUser(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var userName : TextView = itemView.findViewById(R.id.user_name_post)
        var titlePost : TextView = itemView.findViewById(R.id.title_post)
        var bodyPost : TextView = itemView.findViewById(R.id.body_post)
    }

}