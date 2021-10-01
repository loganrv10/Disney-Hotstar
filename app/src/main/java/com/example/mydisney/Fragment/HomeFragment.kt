package com.example.mydisney.Fragment


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.mydisney.Adapter.ComingSoonAdapter
import com.example.mydisney.Adapter.NewMovieAdapter
import com.example.mydisney.Model.ComingSoonDTO
import com.example.mydisney.Model.NowShowingDTO
import com.example.mydisney.Network.Network
import com.example.mydisney.R

import retrofit2.Call
import retrofit2.Response
import com.example.mydisney.Model.ResponseDTO

import com.example.mydisney.Api.EndPoints




class HomeFragment : Fragment(R.layout.fragment_home){
    var comingSoon = listOf<ComingSoonDTO>()
    var NowShowing = listOf<NowShowingDTO>()
    private var recyclerView: RecyclerView? = null
    private var viewPager2: ViewPager2? = null
    private var newMovieAdapter: NewMovieAdapter? = null
    private var progress: ProgressBar? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
        setUpRecyclerView()
        makeNetworkCall()

    }

    private fun makeNetworkCall() {
        val endPoints: EndPoints = Network.Retrofit().create(EndPoints::class.java)
        endPoints.getMovies().enqueue(object : retrofit2.Callback<ResponseDTO> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<ResponseDTO>, response: Response<ResponseDTO>) {
                NowShowing =(response.body()?.nowShowing as List<NowShowingDTO>)
                newMovieAdapter!!.notifyDataSetChanged()
                comingSoon =(response.body()?.comingSoon as List<ComingSoonDTO>)
                viewPager2!!.adapter = ComingSoonAdapter(
                    comingSoon
                )
                progress!!.visibility = View.GONE
            }
            override fun onFailure(call: Call<ResponseDTO>, t: Throwable) {

            }

        })



    }

    private fun setUpRecyclerView() {
        newMovieAdapter = NewMovieAdapter(NowShowing)
        val linearLayoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        recyclerView!!.adapter = newMovieAdapter
        recyclerView!!.layoutManager = linearLayoutManager
    }

    private fun initView(view: View) {
        recyclerView = view.findViewById(R.id.recylerView)
        viewPager2 = view.findViewById(R.id.comingSoonVP)
        progress = view.findViewById(R.id.progress)
    }
}







