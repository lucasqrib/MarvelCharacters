package lucasqrib.com.br.data.di

import lucasqrib.com.br.data.local.CharactersDAO
import lucasqrib.com.br.data.local.CharactersDB
import lucasqrib.com.br.data.remote.api.ApiProvider
import lucasqrib.com.br.data.repositories.CharactersRepository
import lucasqrib.com.br.data.repositories.ICharactersRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object DataModule {
    val module = module {

        single<CharactersDAO> {
            CharactersDB.getInstance(androidContext()).characterDAO()
        }

        single {
            ApiProvider.createApi()
        }

        single<ICharactersRepository> {
            CharactersRepository(
                api = get(),
                charactersDAO = get()
            )
        }
    }
}