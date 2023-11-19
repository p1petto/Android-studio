package com.example.randommovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.google.gson.Gson
import java.io.InputStreamReader
import java.util.Random

class MainActivity : AppCompatActivity() {
    lateinit var movies: Movies
    //    lateinit var movies : Array<String>;
    val r = Random()
    //    val m = Movie("Inception", 2010, 9.0f)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val movies_stream = resources.openRawResource(R.raw.movies)
        val gson = Gson() // конвертор из JSON обратно
        movies = gson.fromJson(InputStreamReader(movies_stream), Movies::class.java)
        Log.d("mytag", "Loaded movies ${movies.movies.size}")
        for (m in movies.movies){
            Log.d("mytag","movie: ${m.name}, ${m.year},${m.rating}")
        }
    }
    fun onClick(view: View){
        if (movies.size != 0){
            val r = Random()
            val index = r.nextInt(movies.size)

            val tvTitle =  findViewById<TextView>(R.id.title)
            val tvYear =  findViewById<TextView>(R.id.year)
            val tvGenre =  findViewById<TextView>(R.id.genre)
            val tvRating =  findViewById<TextView>(R.id.rating)
            val tvActors =  findViewById<TextView>(R.id.actors)
            val tvDirector =  findViewById<TextView>(R.id.director)
            tvTitle.text = movies.movies[index].name.toString()
            tvYear.text = movies.movies[index].year.toString()
            tvGenre.text = movies.movies[index].genre.toString()
            tvRating.text = movies.movies[index].rating.toString()
            tvDirector.text = movies.movies[index].director.contentToString()
            tvActors.text = movies.movies[index].actors.contentToString()

            movies.movies.removeAt(index)
        }
        else{
            val tvTitle =  findViewById<TextView>(R.id.title)
            tvTitle.text = "There is no more films!"
            val tvYear =  findViewById<TextView>(R.id.year)
            val tvGenre =  findViewById<TextView>(R.id.genre)
            val tvRating =  findViewById<TextView>(R.id.rating)
            val tvDirector =  findViewById<TextView>(R.id.director)
            val tvActors =  findViewById<TextView>(R.id.actors)
            tvYear.text = ""
            tvGenre.text = ""
            tvRating.text = ""
            tvDirector.text = ""
            tvActors.text = ""

        }
    }
    fun onClear(view: View){
        val movies_stream = resources.openRawResource(R.raw.movies)
        val gson = Gson() // конвертор из JSON обратно
        movies = gson.fromJson(InputStreamReader(movies_stream), Movies::class.java)
        val tvTitle =  findViewById<TextView>(R.id.title)
        val tvYear =  findViewById<TextView>(R.id.year)
        val tvGenre =  findViewById<TextView>(R.id.genre)
        val tvRating =  findViewById<TextView>(R.id.rating)
        val tvDirector =  findViewById<TextView>(R.id.director)
        val tvActors =  findViewById<TextView>(R.id.actors)

        tvTitle.text = ""
        tvYear.text = ""
        tvGenre.text = ""
        tvRating.text = ""
        tvActors.text = ""
        tvDirector.text = ""

    }
}