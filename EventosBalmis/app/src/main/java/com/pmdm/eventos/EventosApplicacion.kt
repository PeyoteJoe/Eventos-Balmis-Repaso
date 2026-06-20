package com.pmdm.eventos

import android.app.Application
import com.pmdm.eventos.data.EventoRepository
import com.pmdm.eventos.data.mocks.evento.EventoDaoMock
import com.pmdm.eventos.data.toEvento
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltAndroidApp
class EventosApplicacion : Application() {

    @Inject
    lateinit var  eventoRepository: EventoRepository;

    @Inject
    lateinit var eventoDaoMock: EventoDaoMock;

    override fun onCreate() {
        super.onCreate()

        runBlocking {
            if (eventoRepository.count()==0){
                eventoDaoMock.get().forEach { eventoMock -> eventoRepository.insert(eventoMock.toEvento()) }
            }
        }
    }

}