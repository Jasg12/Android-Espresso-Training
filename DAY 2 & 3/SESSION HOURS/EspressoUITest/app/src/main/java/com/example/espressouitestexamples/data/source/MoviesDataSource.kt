package com.example.espressouitestexamples.data.source

import com.example.espressouitestexamples.data.Movie

interface MoviesDataSource {

    fun getMovie(movieId: Int): Movie?

    fun getMovies(): List<Movie>
}