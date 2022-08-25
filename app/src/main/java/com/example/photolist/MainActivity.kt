package com.example.photolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.photolist.Adapter.PhotoAdapter
import com.example.photolist.Model.Photos

class MainActivity : AppCompatActivity() {
    lateinit var mRecyclerView: RecyclerView
    val list : MutableList<Photos> = mutableListOf()
    lateinit var photoAdapter : PhotoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        inserListAnh()
        getListAnh()

    }
    fun init(){
        mRecyclerView = findViewById(R.id.rcyListAnh)
    }
    fun getListAnh(){
        mRecyclerView.layoutManager = GridLayoutManager(this@MainActivity,2)
        photoAdapter = PhotoAdapter(this@MainActivity,list)
        mRecyclerView.adapter = photoAdapter
        photoAdapter.setOnClickItem(object : PhotoAdapter.ClickNhaDep{
            override fun clickChiTiet(poisiton: Int) {

            }

        })
    }
    fun inserListAnh(){
        list.add(Photos(1,R.drawable.nhadep7,"Quán cà phê",1000000))
        list.add(Photos(2,R.drawable.nhadep8,"Shop",5000000))
        list.add(Photos(3,R.drawable.nhadep9,"Cafe Phố",10000000))
        list.add(Photos(4,R.drawable.nhadep4,"Căn hộ",10000000))
        list.add(Photos(5,R.drawable.nhadep5,"Nhà đẹp",51000000))
        list.add(Photos(6,R.drawable.nhadep6,"Nhà nhỏ",3000000))

    }

}