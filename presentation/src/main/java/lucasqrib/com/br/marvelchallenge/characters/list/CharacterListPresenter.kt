package lucasqrib.com.br.marvelchallenge.characters.list

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.functions.BiFunction
import lucasqrib.com.br.domain.character.model.Character
import lucasqrib.com.br.domain.character.model.PageParam
import lucasqrib.com.br.domain.character.model.Query
import lucasqrib.com.br.domain.character.usecases.IAddFavoriteCharacterUseCase
import lucasqrib.com.br.domain.character.usecases.IGetCharactersUseCase
import lucasqrib.com.br.domain.character.usecases.IGetFavoriteCharactersUseCase
import lucasqrib.com.br.domain.character.usecases.IRemoveFavoriteCharacterUseCase
import lucasqrib.com.br.marvelchallenge.characters.CharacterVO
import lucasqrib.com.br.marvelchallenge.utils.rx.subscribeWithDefaultBehavior

class CharacterListPresenter(
    private val view: CharacterListContract.View,
    private val getCharactersUseCase: IGetCharactersUseCase,
    private val getFavoriteCharactersUseCase: IGetFavoriteCharactersUseCase,
    private val addFavoriteCharacterUseCase: IAddFavoriteCharacterUseCase,
    private val removeFavoriteCharacterUseCase: IRemoveFavoriteCharacterUseCase
) : CharacterListContract.Presenter {

    private var offset = 0
    private val limit = 20

    override fun onFavoriteClicked(character: CharacterVO) {
        val subscription = if (character.isFavorite) removeFavoriteCharacterUseCase.execute(character.id)
        else addFavoriteCharacterUseCase.execute(character.toCharacter())
        subscription
            .subscribeWithDefaultBehavior(
                onComplete = {
                    getFavoredCharacterList()
                        .subscribeWithDefaultBehavior(view) {
                            if (it.isNotEmpty())
                                view.showCharacters(it)
                            else view.showEmptyState()
                        }
                }
            )
    }

    override fun getCharacters(getMoreCharacters: Boolean) {
        Observable.zip(
            getCharactersFromApi(getMoreCharacters), getFavoredCharacterList().toObservable()
            , BiFunction { query: Query<List<Character>>, favorites: List<CharacterVO> ->
                offset = query.offset
                query.results.map { it.toCharacterVO() }.apply {
                    favorites.forEach { favorite -> this.find { it.id == favorite.id }?.isFavorite = true }
                }
            }
        ).subscribeWithDefaultBehavior(view)
        {
            if (it.isNotEmpty())
                view.showCharacters(it)
            else view.showEmptyState()
        }
    }


    private fun getCharactersFromApi(getMoreCharacters: Boolean): Observable<Query<List<Character>>> =
        getCharactersUseCase.execute(
            PageParam(
                offset.takeIf { getMoreCharacters } ?: offset - limit,
                limit)
        )

    private fun getFavoredCharacterList(): Single<List<CharacterVO>> {
        return getFavoriteCharactersUseCase.execute().map { it.map { character -> character.toCharacterVO() } }
    }
}