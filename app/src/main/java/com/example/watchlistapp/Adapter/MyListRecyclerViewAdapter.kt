package com.example.watchlistapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.watchlistapp.MovieList.MovieModel
import com.example.watchlistapp.R

class MyListRecyclerViewAdapter (private val context: Context, private val dataset: ArrayList<MovieModel>): RecyclerView.Adapter<MyListRecyclerViewAdapter.ItemViewHolder>() {


    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.movieNameTextView)
        val directorTextView: TextView = view.findViewById(R.id.directorTextView)
        val genreTextView: TextView = view.findViewById(R.id.genreTextView)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyListRecyclerViewAdapter.ItemViewHolder {
        val myProductsRecyclerViewAdapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.single_item, parent, false)

        return ItemViewHolder(myProductsRecyclerViewAdapterLayout)
    }

    override fun onBindViewHolder(
        holder: MyListRecyclerViewAdapter.ItemViewHolder,
        position: Int
    ) {
        val item = dataset[position]
        holder.nameTextView.text = "სახელწოდება: ${item.Name}"
        holder.directorTextView.text = "რეჟისორი: ${item.Director}"
        holder.genreTextView.text = "ჟანრი: ${item.Genre}"
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}