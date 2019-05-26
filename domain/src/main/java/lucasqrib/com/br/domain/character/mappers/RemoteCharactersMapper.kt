package lucasqrib.com.br.domain.character.mappers

import lucasqrib.com.br.data.remote.models.responses.CharacterResponse
import lucasqrib.com.br.data.remote.models.responses.CharactersResponse
import lucasqrib.com.br.data.remote.models.responses.ThumbnailResponse
import lucasqrib.com.br.domain.character.model.Character
import lucasqrib.com.br.domain.character.model.Query

const val LARGE_IMAGE_PARAM = "landscape_incredible"
const val SMALL_IMAGE_PARAM = "landscape_small"

fun CharactersResponse.toQuery(): Query<List<Character>> {
    return Query(
        offset = this.dataResponse.offset,
        results = this.dataResponse.results.map { it.toCharacter() }
    )
}

fun CharacterResponse.toCharacter(): Character {
    return Character(
        id = id,
        name = name,
        description = description,
        smallPhoto = thumbnail.toSmallPhoto(),
        largePhoto = thumbnail.toLargePhoto()
    )
}

fun ThumbnailResponse.toSmallPhoto(): String {
    return "${this.path}/$SMALL_IMAGE_PARAM.${this.extension}"
}

fun ThumbnailResponse.toLargePhoto(): String {
    return "${this.path}/$LARGE_IMAGE_PARAM.${this.extension}"
}




