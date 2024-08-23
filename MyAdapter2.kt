package com.example.myapplication13

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MyAdapter2(private val productImage: List<DataImage>, private val context: Context) :
    RecyclerView.Adapter<MyAdapter2.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.single_row2, parent, false)
        return ViewHolder(layout)
    }

    override fun getItemCount(): Int = productImage.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context)
            .load(productImage[position].image)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
            )
            .into(holder.image)
    }

    class ViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        val image: ImageView = row.findViewById(R.id.imageView2)
    }
}
