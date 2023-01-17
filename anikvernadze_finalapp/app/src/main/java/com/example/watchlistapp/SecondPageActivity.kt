package com.example.watchlistapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.watchlistapp.Adapter.MyListRecyclerViewAdapter
import com.example.watchlistapp.MovieList.MovieModel

class SecondPageActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_page)

        val receivedMovieInfo = intent.getParcelableArrayListExtra<MovieModel>(MOVIE_LIST_KEY) as ArrayList<MovieModel>

        if(receivedMovieInfo.isNotEmpty()){
            val recyclerView: RecyclerView = findViewById(R.id.myProductsRecyclerView)
            recyclerView.adapter = MyListRecyclerViewAdapter(this, receivedMovieInfo)
            recyclerView.setHasFixedSize(true)
        }
    }

}