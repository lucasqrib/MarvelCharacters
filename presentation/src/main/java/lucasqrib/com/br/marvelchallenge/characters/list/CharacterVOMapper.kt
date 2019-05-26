package lucasqrib.com.br.marvelchallenge.characters.list

import lucasqrib.com.br.domain.character.model.Character
import lucasqrib.com.br.marvelchallenge.characters.CharacterVO

fun Character.toCharacterVO(): CharacterVO {
    return CharacterVO(
        id = id,
        largePhoto = largePhoto,
        smallPhoto = smallPhoto,
        description = description,
        name = name,
        isFavorite = false
    )
}

fun CharacterVO.toCharacter(): Character = Character(
    id = id,
    largePhoto = largePhoto,
    smallPhoto = smallPhoto,
    description = description,
    name = name
)