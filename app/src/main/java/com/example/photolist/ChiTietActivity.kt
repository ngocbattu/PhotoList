package com.example.photolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide

class ChiTietActivity : AppCompatActivity() {
        lateinit var  toolbar:androidx.appcompat.widget.Toolbar
        lateinit var txtTenNha :TextView
        lateinit var txtGiaNha : TextView
        lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet)
        toolbar  = findViewById(R.id.toolbarChiTiet)
        txtTenNha = findViewById(R.id.txtTenNha)
        txtGiaNha = findViewById(R.id.txtGiaNha)
        imageView = findViewById(R.id.imageNhaDepCT)
        setSupportActionBar(toolbar)
        toolbar?.navigationIcon = ContextCompat.getDrawable(this,R.drawable.ic_back)
        toolbar?.setTitle("Chi tiết nhà")
        toolbar?.setNavigationOnClickListener(View.OnClickListener {
            startActivity(Intent(this@ChiTietActivity,MainActivity::class.java))
        })

        val i = intent
        Glide.with(this).load(i.getIntExtra("_image",0)).into(imageView)
        txtTenNha.text = "Tên nhà : " +  i.getStringExtra("_nameHome")
        txtGiaNha.text = "Giá nhà :  " + i.getIntExtra("_price",0).toString() +"VND"

    }
}