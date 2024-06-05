package com.example.ensayoplantaapps.Model

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.ensayoplantaapps.Model.Local.Dao.FlowerDao
import com.example.ensayoplantaapps.Model.Local.Entities.FlowerDetail
import com.example.ensayoplantaapps.Model.Remote.RetrofitFlowers
import com.example.ensayoplantaapps.Model.Remote.fromInternetDetailsFlowers
import com.example.ensayoplantaapps.Model.Remote.fromInternetListFlowers

class FlowerRepository (private val flowerDao: FlowerDao) {

    private val networkService = RetrofitFlowers.retrofitInstance()

    val flowerListLiveData = flowerDao.getAllFlowers()


    //API
    suspend fun fetchList() {
        val service = kotlin.runCatching { networkService.fetchFlowersList() }

        service.onSuccess {

            when (it.code()) {
                in 200..299 -> it.body()?.let {

                    Log.d("Flowers", it.toString())


                    flowerDao.insertAllFlowers(fromInternetListFlowers(it))


                }

                else -> Log.d("Repo", "${it.code()}-${it.errorBody()}")
            }
            service.onFailure {
                Log.e("Error", "${it.message}")
            }


        }
    }

    suspend fun fetchFlowersDetails (id: Int): FlowerDetail? {

        val service = kotlin.runCatching { networkService.fetchFlowersDetail(id)}

        return service.getOrNull()?.body()?.let { Details ->

            val flowersDetails = fromInternetDetailsFlowers(Details)

            flowerDao.insertFlowerDetails(flowersDetails)
            flowersDetails
        }

    }

    fun getFlowersDetailsById(id: Int): LiveData<FlowerDetail> {
        return flowerDao.getFlowersDetailById(id)
    }

}