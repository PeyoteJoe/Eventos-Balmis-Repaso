package com.pmdm.eventos.di

import android.content.Context
import com.pmdm.eventos.data.EventoRepository
import com.pmdm.eventos.data.mocks.evento.EventoDaoMock
import com.pmdm.eventos.data.mocks.suscripcion.SuscripcionDaoMock
import com.pmdm.eventos.data.mocks.suscripcion.SuscripcionMock
import com.pmdm.eventos.data.room.EventoDB
import com.pmdm.eventos.data.room.EventoDao
import com.pmdm.eventos.ui.features.presentacion_eventos.EventosScreen
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.Contexts
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesEventoDatabase(
        @ApplicationContext context: Context
    ): EventoDB = EventoDB.getDatabase(context);

    @Provides
    @Singleton
    fun provideSuscripcionDaoMock(): SuscripcionDaoMock= SuscripcionDaoMock()

    @Provides
    @Singleton
    fun provideEventoDaoMock(): EventoDaoMock = EventoDaoMock()

    @Provides
    @Singleton
    fun provideEventoRepository(
        eventoDao: EventoDao,
        suscripcionDaoMock: SuscripcionDaoMock
    ): EventoRepository =EventoRepository(eventoDao,suscripcionDaoMock);


}