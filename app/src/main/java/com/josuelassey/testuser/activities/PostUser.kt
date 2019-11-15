package com.josuelassey.testuser.activities

import android.app.ProgressDialog
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.josuelassey.testuser.R
import com.josuelassey.testuser.adapter.PostAdapter
import com.josuelassey.testuser.remote_model.PostUser
import com.josuelassey.testuser.retrofit.client.ApiClientPostUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("DEPRECATION")
class PostUser : AppCompatActivity() {

    lateinit var progressDialog : ProgressDialog
    var postuserList = arrayListOf<PostUser>()
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_user)

        initObjects()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Setting up adapter
        recyclerView.adapter = PostAdapter(postuserList, this)
        recyclerView.layoutManager = GridLayoutManager(this, 4)


        progressDialog.setCancelable(false)
        progressDialog.setTitle("Chargement des postes des utilisateurs")
        progressDialog.show()

        getPostuser()
    }
    private fun initObjects() {
        recyclerView = findViewById(R.id.rv_post_user)
        progressDialog = ProgressDialog(this)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home){
            this.finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getPostuser(){
        val call : Call<List<PostUser>> = ApiClientPostUser.getClientPostUser.getPostUser()
        call.enqueue(object : Callback<List<PostUser>> {
            override fun onFailure(call: Call<List<PostUser>>, t: Throwable) {
               progressDialog.dismiss()
            }

            override fun onResponse(
                call: Call<List<PostUser>>,
                response: Response<List<PostUser>>
            ) {
                progressDialog.dismiss()
                postuserList.addAll(response.body()!!)
                recyclerView.adapter?.notifyDataSetChanged()
            }


        })
    }
}
