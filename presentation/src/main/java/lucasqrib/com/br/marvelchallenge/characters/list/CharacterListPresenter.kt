package lucasqrib.com.br.marvelchallenge.characters.list

import lucasqrib.com.br.marvelchallenge.characters.CharacterVO

class CharacterListPresenter(private val view: CharacterListContract.View) :
    CharacterListContract.Presenter {


    override fun init(isShowOnlyFavorites: Boolean?) {
        if (isShowOnlyFavorites == true) view.showCharacters(getFavoritedCharacterList())
        else view.showCharacters(getCharacterList())
    }

    private fun getCharacterList(): List<CharacterVO> {
        return listOf(
            CharacterVO(id = "1", name = "Thor"),
            CharacterVO(id = "2", name = "Hulk"),
            CharacterVO(id = "3", name = "Iron Man"),
            CharacterVO(id = "4", name = "Antman"),
            CharacterVO(id = "5", name = "Spiderman")
        )
    }

    private fun getFavoritedCharacterList(): List<CharacterVO> {
        return listOf(
            CharacterVO(id = "1", name = "Thor", isFavorite = true),
            CharacterVO(id = "4", name = "Antman", isFavorite = true),
            CharacterVO(id = "5", name = "Spiderman", isFavorite = true)
        )
    }
}