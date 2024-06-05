package com.example.ensayoplantaapps.Model.Remote

import com.example.ensayoplantaapps.Model.Remote.Frominternet.DetailsFlower
import com.example.ensayoplantaapps.Model.Remote.Frominternet.ListFlower
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface FlowerApi {

    @GET ("plantas")
        suspend fun fetchFlowersList():Response<List<ListFlower>>



    @GET ("plantas/{id}")
        suspend fun fetchFlowersDetail(@Path ("id") id: Int) : Response<DetailsFlower>

}