package com.example.myapplication13

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MyAdapter(val productData: MutableList<ProductData>, val context: Context) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.single_row, parent, false)
        return ViewHolder(layout)
    }

    override fun getItemCount(): Int = productData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = productData[position].title
        Glide.with(context)
            .load(productData[position].image)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
            )
            .into(holder.image)
        holder.price.text = productData[position].price.toString() + " $"

        holder.image.setOnClickListener {
            val bundle = Bundle().apply {
                putInt("pos", position)
            }
            Navigation.findNavController(context as Activity, R.id.nav_host_fragment)
                .navigate(R.id.action_mainFragment_to_imageFragment, bundle)
        }
    }

    class ViewHolder(private val row: View) : RecyclerView.ViewHolder(row) {
        var image: ImageView = row.findViewById(R.id.imageView)
        var price: TextView = row.findViewById(R.id.textViewPrice)
        var title: TextView = row.findViewById(R.id.textViewTitle)
    }
}
