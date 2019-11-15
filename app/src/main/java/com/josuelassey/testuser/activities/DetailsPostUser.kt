package com.josuelassey.testuser.activities

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.josuelassey.testuser.R
import com.josuelassey.testuser.adapter.AdapterDetailsPostUser
import com.josuelassey.testuser.remote_model.PostUser
import com.josuelassey.testuser.retrofit.client.ApiClientPostUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("DEPRECATION")
class DetailsPostUser : AppCompatActivity() {

    lateinit var progressDialog : ProgressDialog
    lateinit var recyclerView: RecyclerView
    var postList = arrayListOf<PostUser>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_post_user)

        initObjects()

        //Setting up adapter
        recyclerView.adapter = AdapterDetailsPostUser(this, postList)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        progressDialog.setCancelable(false)
        progressDialog.setTitle("Details des postes des utilisateurs")
        progressDialog.show()

        getDetailsPostuser()

    }

    private fun initObjects() {
        recyclerView = findViewById(R.id.rv_details_post_user)
        progressDialog = ProgressDialog(this)

    }
    private fun getDetailsPostuser(){
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
                postList.addAll(response.body()!!)
                recyclerView.adapter?.notifyDataSetChanged()
            }


        })
    }
}
