package com.we.movieapp.ui.view.adapter

import android.os.Handler
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.we.movieapp.R
import com.we.movieapp.databinding.MovieListItemBinding
import com.we.movieapp.domain.entities.MovieEntity

class SimilarMoviesAdapter : RecyclerView.Adapter<SimilarMoviesAdapter.ViewHolder>() {

    private val movies: MutableList<MovieEntity> = ArrayList()
    private var layoutInflater: LayoutInflater? = null

    var onMovieClickListener: OnMovieClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ViewHolder {

        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.context)
        }

        val binding: MovieListItemBinding =
            DataBindingUtil.inflate(layoutInflater!!,
                R.layout.movie_list_item, parent, false)



//        return ViewHolder(
//            LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item, parent, false),
//            onMovieClickListener
//        )

        return ViewHolder(
            binding
        )
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
//        viewHolder.bind(movies[position])
//        viewHolder.binding.movie = movies[position]


//        viewHolder.binding.movieTitle.text = movies[position].title
        Handler().postDelayed(Runnable {  Picasso.get()
            .load("https://image.tmdb.org/t/p/w200/${movies[position].posterPath}")
            .into(viewHolder.binding.movieImage, object : Callback {
                override fun onSuccess() {
                    viewHolder.binding.imageProgress.hide()
                }

                override fun onError(e: Exception?) {
                    viewHolder.binding.imageProgress.hide()
                }

            }
            )},1000)

        viewHolder.binding.itemView.setOnClickListener {
            onMovieClickListener?.setOnMovieClickListener(movies[position].id)
        }

    }

    override fun getItemCount() = movies.size

    fun submitList(newMovies: List<MovieEntity>?) {
        newMovies?.let {
            movies.addAll(it)
            val uniqueMovieList = movies.distinctBy { movie ->
                movie.id
            }
            movies.clear()
            movies.addAll(uniqueMovieList)
            notifyDataSetChanged()
        }
    }

    @Suppress("unused")
    fun clear() {
        movies.clear()
        notifyDataSetChanged()
    }

    interface OnMovieClickListener {
        fun setOnMovieClickListener(movieId: Int)
    }

    class ViewHolder(val binding: MovieListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

//    class ViewHolder(itemView: MovieListItemBinding, private val onMovieClickListener: OnMovieClickListener?) :
//        RecyclerView.ViewHolder(itemView.root) {
//
////        fun bind(movie: Result) {
////            itemView.movie_title.text = movie.title
//////            Glide.with(itemView.context)
//////                .load("https://image.tmdb.org/t/p/w200/" + movie.posterPath)
//////                .into(itemView.movie_image)
////
////            Picasso.get()
////                .load("https://image.tmdb.org/t/p/w200/" + movie.posterPath     )
//////                .transform(CropSquareTransformation(10, 0))
////                .into(itemView.movie_image, object : Callback {
////                    override fun onSuccess() {
////                        itemView.image_progress.hide()
////                    }
////
////                    override fun onError(e: Exception?) {
////                        itemView.image_progress.hide()
////                    }
////
////                }
////                )
////            itemView.setOnClickListener {
////                onMovieClickListener?.setOnMovieClickListener(movie.id)
////            }
////        }
//
//    }

}
