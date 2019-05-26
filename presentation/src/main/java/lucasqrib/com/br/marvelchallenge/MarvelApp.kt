package lucasqrib.com.br.marvelchallenge

import android.app.Application
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import lucasqrib.com.br.data.remote.api.ApiProvider
import lucasqrib.com.br.data.di.DataModule
import lucasqrib.com.br.domain.di.DomainModule
import lucasqrib.com.br.marvelchallenge.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MarvelApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MarvelApp)
            modules(PresentationModule.module, DomainModule.module, DataModule.module)
        }
        configurePicasso()
    }

    private fun configurePicasso() {
        val downloader = OkHttp3Downloader(ApiProvider.provideOkttp())
        Picasso.setSingletonInstance(
            Picasso.Builder(this)
                .downloader(downloader)
                .build()
        )
    }

}