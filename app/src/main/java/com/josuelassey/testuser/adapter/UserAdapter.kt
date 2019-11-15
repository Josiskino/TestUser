package com.josuelassey.testuser.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.josuelassey.testuser.R
import com.josuelassey.testuser.remote_model.User

class UserAdapter(
    private  var userList: List<User>,
    private val context: Context
) : RecyclerView.Adapter<UserAdapter.ViewHolderUser>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderUser {
        return ViewHolderUser(LayoutInflater.from(context).inflate(R.layout.list_user, parent, false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolderUser, position: Int) {
        val user = userList[position]
        holder.name.text = user.name
        holder.userName.text = user.userName
        holder.userEmail.text = user.userEmail
    }


    class ViewHolderUser(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name : TextView = itemView.findViewById(R.id.name)
        var userName : TextView = itemView.findViewById(R.id.user_name)
        var userEmail : TextView = itemView.findViewById(R.id.user_email)
    }
}