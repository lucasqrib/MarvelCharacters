package lucasqrib.com.br.marvelchallenge.di

import lucasqrib.com.br.marvelchallenge.characters.list.CharacterListContract
import lucasqrib.com.br.marvelchallenge.characters.list.CharacterListPresenter
import lucasqrib.com.br.marvelchallenge.characters.list.FavoriteCharacterListPresenter
import org.koin.core.qualifier.named
import org.koin.dsl.module

object PresentationModule {
    const val IS_FAVORITE = "IS_FAVORITE"
    const val IS_NOT_FAVORITE = "IS_NOT_FAVORITE"

    val module = module {
        single<CharacterListContract.Presenter>(named(IS_NOT_FAVORITE)) { (view: CharacterListContract.View) ->
            CharacterListPresenter(
                view = view,
                getCharactersUseCase = get(),
                getFavoriteCharactersUseCase = get(),
                removeFavoriteCharacterUseCase = get(),
                addFavoriteCharacterUseCase = get()
            )
        }

        single<CharacterListContract.Presenter>(named(IS_FAVORITE)) { (view: CharacterListContract.View) ->
            FavoriteCharacterListPresenter(
                view = view,
                addFavoriteCharacterUseCase = get(),
                getFavoriteCharactersUseCase = get(),
                removeFavoriteCharacterUseCase = get()
            )
        }

    }
}