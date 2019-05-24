package lucasqrib.com.br.marvelchallenge.characters.list

import lucasqrib.com.br.marvelchallenge.characters.CharacterVO


object CharacterListContract {
    interface View {
        fun showCharacters(characterList: List<CharacterVO>)
    }

    interface Presenter {
        fun init(isShowOnlyFavorites: Boolean?)
    }
}