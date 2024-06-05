package com.example.ensayoplantaapps.View.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ensayoplantaapps.Model.Local.Entities.FlowersList
import com.example.ensayoplantaapps.databinding.FlowerlistBinding

class ListAdapter: RecyclerView.Adapter<ListAdapter.viewholder>() {

    private var listFlowers = listOf<FlowersList>()
    private val selectedFlower = MutableLiveData<FlowersList>()
    fun selectedFlower(): LiveData<FlowersList> = selectedFlower

    inner class viewholder(private val binding: FlowerlistBinding ):
        RecyclerView.ViewHolder(binding.root), View.OnClickListener{

        fun bind(list: FlowersList){

            Glide.with(binding.imageRv).load(list.imagen).centerCrop().into(binding.imageRv)
            binding.textNameRV.text= "Name:{list.name}"
            binding.textTipoRV.text= "Type:{list.tipo}"
            itemView.setOnClickListener(this)

        }

        override fun onClick(v: View?) {

            selectedFlower.value= listFlowers[bindingAdapterPosition]
            Log.d("ONCLICK", bindingAdapterPosition.toString())
        }

    }
    fun update(list: List<FlowersList>) {
        listFlowers = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.viewholder {
        return viewholder(FlowerlistBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ListAdapter.viewholder, position: Int) {
        holder.bind(listFlowers[position])
    }

    override fun getItemCount(): Int = listFlowers.size



}