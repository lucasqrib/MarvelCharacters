package lucasqrib.com.br.marvelchallenge

import android.app.Application
import lucasqrib.com.br.marvelchallenge.characters.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MarvelApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MarvelApp)
            modules(PresentationModule.module)
        }
    }

}