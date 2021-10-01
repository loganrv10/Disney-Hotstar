package com.example.mydisney.Fragment

import android.graphics.drawable.ClipDrawable.HORIZONTAL
import android.net.Network
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mydisney.Adapter.MovieFragmentComingSoonAdapter
import com.example.mydisney.Api.EndPoints
import com.example.mydisney.Model.ComingSoonDTO
import com.example.mydisney.Model.ResponseDTO
import com.example.mydisney.Network.Network.Retrofit
import com.example.mydisney.R
import retrofit2.Call
import retrofit2.Response



class MoviesFragment : Fragment(R.layout.fragment_movies) {
  var comMovieFragmentList = listOf<ComingSoonDTO>()
   private var movieRecyclerView : RecyclerView? = null


  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    ApiCall()
  }

  private fun ApiCall(){
    val endPoints: EndPoints = Network.Retrofit().create(EndPoints::class.java)
         endPoints.getMovies().enqueue(object : retrofit2.Callback<ResponseDTO>{
           override fun onResponse(call: Call<ResponseDTO>, response: Response<ResponseDTO>) {
             comMovieFragmentList = response.body()?.comingSoon as List<ComingSoonDTO>
             setRecyclerView()
           }

           override fun onFailure(call: Call<ResponseDTO>, t: Throwable) {
           }




  })
  }

  private fun setRecyclerView() {
    val movieFragmentComingSoonAdapter = MovieFragmentComingSoonAdapter(comMovieFragmentList)
    val linearLayoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
    movieRecyclerView!!.adapter = movieFragmentComingSoonAdapter
    movieRecyclerView!!.layoutManager = linearLayoutManager
  }


}



