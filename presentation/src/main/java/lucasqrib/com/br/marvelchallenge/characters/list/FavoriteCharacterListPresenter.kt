package lucasqrib.com.br.marvelchallenge.characters.list


import io.reactivex.Single
import lucasqrib.com.br.domain.character.usecases.IAddFavoriteCharacterUseCase
import lucasqrib.com.br.domain.character.usecases.IGetFavoriteCharactersUseCase
import lucasqrib.com.br.domain.character.usecases.IRemoveFavoriteCharacterUseCase
import lucasqrib.com.br.marvelchallenge.characters.CharacterVO
import lucasqrib.com.br.marvelchallenge.utils.rx.subscribeWithDefaultBehavior

class FavoriteCharacterListPresenter(
    private val view: CharacterListContract.View,
    private val getFavoriteCharactersUseCase: IGetFavoriteCharactersUseCase,
    private val addFavoriteCharacterUseCase: IAddFavoriteCharacterUseCase,
    private val removeFavoriteCharacterUseCase: IRemoveFavoriteCharacterUseCase
) : CharacterListContract.Presenter {
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
        getFavoredCharacterList()
            .subscribeWithDefaultBehavior(view) {
                if (it.isNotEmpty())
                    view.showCharacters(it)
                else view.showEmptyState()
            }
    }

    private fun getFavoredCharacterList(): Single<List<CharacterVO>> {
        return getFavoriteCharactersUseCase.execute().map { it.map { character -> character.toCharacterVO() } }
    }
}