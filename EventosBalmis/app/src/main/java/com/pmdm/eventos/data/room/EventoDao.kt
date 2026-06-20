package com.pmdm.eventos.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
@Dao
interface EventoDao {


    @Query("SELECT * FROM eventos")
    suspend fun get(): List<EventoEntity>;

    @Query("SELECT * FROM eventos where Id = :id")
    suspend fun get(id: Int): EventoEntity;

    @Insert
    suspend fun insert(eventoEntity: EventoEntity);

    @Update
    suspend fun update(eventoEntity: EventoEntity);

    @Query("SELECT count(*) FROM eventos")
    suspend fun count(): Int;

}