package lucasqrib.com.br.marvelchallenge.characters.detail

import lucasqrib.com.br.domain.character.usecases.IAddFavoriteCharacterUseCase
import lucasqrib.com.br.domain.character.usecases.IRemoveFavoriteCharacterUseCase
import lucasqrib.com.br.marvelchallenge.characters.CharacterVO
import lucasqrib.com.br.marvelchallenge.characters.list.toCharacter
import lucasqrib.com.br.marvelchallenge.utils.rx.subscribeWithDefaultBehavior

class CharacterDetailsPresenter(
    val view: CharacterDetailsContract.View,
    private val removeFavoriteCharacterUseCase: IRemoveFavoriteCharacterUseCase,
    private val addFavoriteCharacterUseCase: IAddFavoriteCharacterUseCase
) : CharacterDetailsContract.Presenter {

    override fun onFavoriteClicked(character: CharacterVO?) {
        if (character == null) {
            view.showError()
            return
        }
        val subscription = if (character.isFavorite) removeFavoriteCharacterUseCase.execute(character.id)
        else addFavoriteCharacterUseCase.execute(character.toCharacter())
        subscription
            .subscribeWithDefaultBehavior(
                onComplete = {
                    character.isFavorite = !character.isFavorite
                    view.updateCharacter(character)
                }
            )
    }
}