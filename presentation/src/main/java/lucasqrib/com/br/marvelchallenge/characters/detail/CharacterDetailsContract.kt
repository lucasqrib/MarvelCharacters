package lucasqrib.com.br.marvelchallenge.characters.detail

import lucasqrib.com.br.marvelchallenge.characters.CharacterVO
import lucasqrib.com.br.marvelchallenge.utils.rx.views.BaseView

object CharacterDetailsContract {
    interface View : BaseView {
        fun updateCharacter(character: CharacterVO)
    }

    interface Presenter {
        fun onFavoriteClicked(character: CharacterVO?)
    }
}