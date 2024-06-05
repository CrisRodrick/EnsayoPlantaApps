package com.example.ensayoplantaapps.Model.Local.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "List_Flowers")
data class FlowersList (
    @PrimaryKey
    val id: Int,
    val nombre: String,
    val tipo: String,
    val imagen: String,
    val descripcion: String


)
