package com.example.ensayoplantaapps.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.ensayoplantaapps.Model.FlowerRepository
import com.example.ensayoplantaapps.Model.Local.Database.FlowerDataBase
import com.example.ensayoplantaapps.Model.Local.Entities.FlowerDetail
import com.example.ensayoplantaapps.Model.Local.Entities.FlowersList
import kotlinx.coroutines.launch

class FlowersViewModel(application: Application): AndroidViewModel (application) {

    private val repository: FlowerRepository
    private var idSelected: Int = 0

        init {
            val bd = FlowerDataBase.getdatabase(application)
            val Dao = bd.getFlowerDao()
            repository = FlowerRepository(Dao)

            viewModelScope.launch {
                repository.fetchList()}

        }


    fun getFlowersList(): LiveData<List<FlowersList>> = repository.flowerListLiveData


    fun getFlowersDetailsByIdFromInternet(id: Int) = viewModelScope.launch {
        idSelected = id
        repository.fetchFlowersDetails(id)

    }

    fun getFlowersDetail(): LiveData<FlowerDetail> = repository.getFlowersDetailsById(idSelected)

}