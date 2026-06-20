package com.pmdm.eventos.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase


@Database(
    entities = [EventoEntity::class],
    version = 1
)
abstract class EventoDB : RoomDatabase() {
    abstract fun EventoDao(): EventoDao;

    companion object {
        fun getDatabase(context: Context) = databaseBuilder(
            context,
            EventoDB::class.java, "eventos.db"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

}