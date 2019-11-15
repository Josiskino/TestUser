package com.josuelassey.testuser.activities

import android.app.ProgressDialog
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.josuelassey.testuser.R
import com.josuelassey.testuser.adapter.UserAdapter
import com.josuelassey.testuser.remote_model.User
import com.josuelassey.testuser.retrofit.client.ApiClientUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("DEPRECATION")
class ListUser : AppCompatActivity() {

    lateinit var progressDialog : ProgressDialog
    var userList = arrayListOf<User>()
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_user)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Method initializing objects
        initObjects()

        //Setting up adapter
        recyclerView.adapter = UserAdapter(userList, this)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        progressDialog.setCancelable(false)
        progressDialog.setTitle("Chargement des utilisateurs")
        progressDialog.show()

        getUser()

    }

    private fun initObjects() {
        recyclerView = findViewById(R.id.rv_list_user)
        progressDialog = ProgressDialog(this)

    }

    private fun getUser(){
        val call : Call<List<User>> = ApiClientUser.getClientUser.getUsers()
        call.enqueue(object : Callback<List<User>>{
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                progressDialog.dismiss()
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                progressDialog.dismiss()
                userList.addAll(response.body()!!)
                recyclerView.adapter?.notifyDataSetChanged()
            }

        })
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home){
            this.finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
