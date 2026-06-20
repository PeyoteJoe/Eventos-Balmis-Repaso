package com.pmdm.eventos.data

import com.pmdm.eventos.data.mocks.suscripcion.SuscripcionDaoMock
import com.pmdm.eventos.data.room.EventoDao
import com.pmdm.eventos.data.room.EventoEntity
import com.pmdm.eventos.models.Evento
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class EventoRepository @Inject constructor(
    private val eventosDao: EventoDao,
    private val suscripcionDaoMock: SuscripcionDaoMock
) {
    suspend fun count() = withContext(Dispatchers.IO) {
        eventosDao.count();
    }

    suspend fun insert(evento: Evento) = withContext(Dispatchers.IO) {
        eventosDao.insert(evento.toEventoEntity());
    }

    suspend fun update(eventoEntity: EventoEntity) = withContext(Dispatchers.IO) {
        eventosDao.update(eventoEntity);
    }

    suspend fun get() = withContext(Dispatchers.IO) {
        eventosDao.get();
    }

    suspend fun get(id: Int) = withContext(Dispatchers.IO) {
        eventosDao.get(id);
    }

    suspend fun getSuscriptores() = withContext(Dispatchers.IO){
        suscripcionDaoMock.get();
    }
}