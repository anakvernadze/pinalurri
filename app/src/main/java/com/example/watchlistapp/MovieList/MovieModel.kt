package com.example.watchlistapp.MovieList

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieModel (val Name: String, val Director: String, val Genre: String): Parcelable

