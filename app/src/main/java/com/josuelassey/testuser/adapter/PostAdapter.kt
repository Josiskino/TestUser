package com.josuelassey.testuser.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.josuelassey.testuser.activities.DetailsPostUser
import com.josuelassey.testuser.R
import com.josuelassey.testuser.remote_model.PostUser

class PostAdapter(
    private var postList: List<PostUser>,
    private val context: Context
) : RecyclerView.Adapter<PostAdapter.ViewHolderPost>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPost {
        return ViewHolderPost(LayoutInflater.from(context).inflate(R.layout.post_user, parent, false))
    }

    override fun getItemCount(): Int {
       return postList.size
    }

    override fun onBindViewHolder(holder: ViewHolderPost, position: Int) {
        var posts = postList[position]
        holder.postId.text = posts.id.toString()

        holder.postCv.setOnClickListener {
            var intent = Intent(context, DetailsPostUser::class.java)
            context.startActivity(intent)
        }
    }

    class ViewHolderPost(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var postId : TextView = itemView.findViewById(R.id.post_id)
        var postCv : CardView = itemView.findViewById(R.id.cv_post_user)
    }
}