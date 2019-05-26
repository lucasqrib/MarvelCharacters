package lucasqrib.com.br.domain.character.mappers

import lucasqrib.com.br.data.local.models.FavoriteCharacter
import lucasqrib.com.br.domain.character.model.Character

fun FavoriteCharacter.toCharacter() = Character(
    id = id,
    name = name,
    description = description,
    smallPhoto = smallPhoto,
    largePhoto = largePhoto
)

fun Character.toFavoriteCharacter() = FavoriteCharacter(
    id = id,
    name = name,
    description = description,
    smallPhoto = smallPhoto,
    largePhoto = largePhoto,
    isFavorite = true
)