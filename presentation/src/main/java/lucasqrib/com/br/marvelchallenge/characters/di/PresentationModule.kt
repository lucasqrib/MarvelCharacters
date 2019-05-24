package lucasqrib.com.br.marvelchallenge.characters.di

import lucasqrib.com.br.marvelchallenge.characters.list.CharacterListContract
import lucasqrib.com.br.marvelchallenge.characters.list.CharacterListPresenter
import org.koin.dsl.module

object PresentationModule {
    val module = module {
        single<CharacterListContract.Presenter> { (view: CharacterListContract.View) ->
            CharacterListPresenter(
                view = view
            )
        }
    }
}