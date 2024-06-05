package com.example.ensayoplantaapps.Model.Local.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ensayoplantaapps.Model.Local.Dao.FlowerDao
import com.example.ensayoplantaapps.Model.Local.Entities.FlowerDetail
import com.example.ensayoplantaapps.Model.Local.Entities.FlowersList


@Database(entities = [FlowersList::class, FlowerDetail::class], version = 1, exportSchema = false)
abstract class FlowerDataBase : RoomDatabase() {
    abstract fun getFlowerDao(): FlowerDao

    companion object {


        @Volatile
        private var INSTANCE: FlowerDataBase? = null

        fun getdatabase(context: Context): FlowerDataBase {

            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FlowerDataBase::class.java,
                    "Flowers_database"
                ).build()
                INSTANCE = instance

                return instance
            }
        }
    }

}