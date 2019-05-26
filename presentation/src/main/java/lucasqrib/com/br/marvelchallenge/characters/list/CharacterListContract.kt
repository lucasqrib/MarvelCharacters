package lucasqrib.com.br.marvelchallenge.characters.list

import lucasqrib.com.br.marvelchallenge.characters.CharacterVO
import lucasqrib.com.br.marvelchallenge.utils.rx.views.BaseView


object CharacterListContract {
    interface View : BaseView {
        fun showCharacters(characterList: List<CharacterVO>)
    }

    interface Presenter {
        fun getCharacters(getMoreCharacters: Boolean = true)
        fun onFavoriteClicked(character: CharacterVO)
    }
}