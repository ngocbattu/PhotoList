package com.example.photolist.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.photolist.ChiTietActivity
import com.example.photolist.MainActivity
import com.example.photolist.Model.Photos
import com.example.photolist.R

class PhotoAdapter(
    private val context: MainActivity,
    private val list: MutableList<Photos>
): RecyclerView.Adapter<PhotoAdapter.ViewHodelPhoto>() {
    private lateinit var clickNhaDep : ClickNhaDep
    fun setOnClickItem(click : ClickNhaDep){
        clickNhaDep = click
    }
    class ViewHodelPhoto(view: View,listener :ClickNhaDep):RecyclerView.ViewHolder(view) {
        var imageAnh: ImageView = view.findViewById(R.id.imageAnh)

        init {
            imageAnh.setOnClickListener(View.OnClickListener {
                listener.clickChiTiet(adapterPosition)
            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoAdapter.ViewHodelPhoto {
        return ViewHodelPhoto(LayoutInflater.from(parent.context).inflate(R.layout.item_recy_view_list_photos,parent,false),clickNhaDep)
    }

    override fun onBindViewHolder(holder: PhotoAdapter.ViewHodelPhoto, position: Int) {
       val photos : Photos = list.get(position)
        val item = list[position]
        Glide.with(context).load(photos.imageAnh).into(holder.imageAnh)
        holder.imageAnh.setOnClickListener {
           val intent  = Intent(context, ChiTietActivity::class.java)
            intent.putExtra("_id",item.idAnh)
            intent.putExtra("_image",item.imageAnh)
            intent.putExtra("_nameHome",item.nameHome)
            intent.putExtra("_price",item.price)
           context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface ClickNhaDep{
        fun clickChiTiet(poisiton : Int)
    }

}