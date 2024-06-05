package com.example.ensayoplantaapps.Model.Remote

import com.example.ensayoplantaapps.Model.Local.Entities.FlowerDetail
import com.example.ensayoplantaapps.Model.Local.Entities.FlowersList
import com.example.ensayoplantaapps.Model.Remote.Frominternet.DetailsFlower
import com.example.ensayoplantaapps.Model.Remote.Frominternet.ListFlower


fun fromInternetListFlowers (flowerList: List<ListFlower>): List<FlowersList> {

    return flowerList.map {
        FlowersList(
            id = it.id,
            nombre = it.nombre,
            tipo = it.tipo,
            imagen = it.imagen,
            descripcion = it.descripcion

        )
    }
}

fun fromInternetDetailsFlowers(detailsFlower: DetailsFlower): FlowerDetail {

    return FlowerDetail (
        id = detailsFlower.id,
        nombre = detailsFlower.nombre,
        tipo = detailsFlower.tipo,
        imagen = detailsFlower.imagen,
        descripcion = detailsFlower.descripcion
    )

}


