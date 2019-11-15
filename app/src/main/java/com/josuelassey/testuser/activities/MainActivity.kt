package com.josuelassey.testuser.activities

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.josuelassey.testuser.R

class MainActivity : AppCompatActivity() {

    lateinit var btnListUser : Button
    lateinit var btnPostUser : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Method initializing objects
        initObjects()

        //Access to the list of users
        btnListUser.setOnClickListener {
            val intent = Intent(baseContext, ListUser::class.java)
            startActivity(intent)
        }
        //Access to the post of users
        btnPostUser.setOnClickListener {
            val intent = Intent(baseContext, PostUser::class.java)
            startActivity(intent)
        }


    }

    //Method initializing objects
    private fun initObjects() {
        btnListUser = findViewById(R.id.btn_list_user)
        btnPostUser = findViewById(R.id.btn_post_user)
    }

    override fun onBackPressed() {
        exit()
    }
    private fun exit(){
        val dialog = androidx.appcompat.app.AlertDialog.Builder(this)
        dialog.setTitle("Confirmation de sortie")
        dialog.setMessage("Êtes-vous sûr de vouloir quitter notre application test?")
        dialog.setCancelable(false)
        dialog.setNegativeButton("Non, rester") { dialog, _ -> dialog.dismiss()  }
        dialog.setPositiveButton("Oui, sortir") { _, _ -> this.finish()  }
        dialog.create()
        dialog.show()
    }

}
