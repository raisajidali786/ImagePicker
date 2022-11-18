package com.rsa.codewsa.imagepicker

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var btnPickImage: Button
    private lateinit var iv : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init
        btnPickImage = findViewById(R.id.btn_pick_image)
        iv = findViewById(R.id.image_view)

        //clickLister
        btnPickImage.setOnClickListener {
            pickImage()
        }
    }
    private fun pickImage(){
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        resultLauncher.launch(intent)
    }

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode == Activity.RESULT_OK){
            val data : Intent? = it.data
            iv.setImageURI(data?.data)
        }
    }
}