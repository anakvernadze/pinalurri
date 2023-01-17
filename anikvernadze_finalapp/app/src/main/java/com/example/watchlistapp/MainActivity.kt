package com.example.watchlistapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.watchlistapp.MovieList.MovieModel
import com.example.watchlistapp.databinding.ActivityMainBinding
import com.example.watchlistapp.databinding.ActivitySecondPageBinding
import kotlinx.parcelize.Parcelize

const val MOVIE_OBJECT_KEY = "com.example.myapplication.MOVIE_OBJECT_KEY"
const val MOVIE_LIST_KEY = "com.example.myapplication.MOVIE_LIST_KEY"

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val myMovies = ArrayList<MovieModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate((layoutInflater))
        setContentView(binding.root)
        binding.myListButton.setOnClickListener() {
            var myMoviesBundle = Bundle()
            myMoviesBundle.putParcelableArrayList(MOVIE_LIST_KEY, myMovies)

            val myMovies: Intent = Intent(this, SecondPageActivity::class.java)
            myMovies.putExtras(myMoviesBundle)
            startActivity(myMovies)

                    }

            binding.addButton.setOnClickListener() {
                if (binding.movieNameEditText.text.toString().isEmpty() || binding.genreEditText.text.toString().isEmpty()) {
                    Toast.makeText(this, "არ არის საკმარისი ინფორმაცია", Toast.LENGTH_SHORT).show()
                }else{
                    val movie = MovieModel("${binding.movieNameEditText.text}", "${binding.directorEditText.text}", "${binding.genreEditText.text}")
                    myMovies.add(movie)
                    Log.d("movies", "$myMovies")
                    Toast.makeText(this, "ფილმი დაემატა", Toast.LENGTH_SHORT).show()
                }
            }

    }

}


