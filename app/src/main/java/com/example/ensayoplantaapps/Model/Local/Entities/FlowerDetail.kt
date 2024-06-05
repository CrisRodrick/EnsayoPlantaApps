package com.example.ensayoplantaapps.Model.Local.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "Details_flowers")
data class FlowerDetail (
@PrimaryKey
    val id: Int,
    val nombre: String,
    val tipo: String,
    val imagen: String,
    val descripcion: String
)
