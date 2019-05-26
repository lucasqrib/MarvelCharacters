package lucasqrib.com.br.domain.character.usecases.implementations

import io.reactivex.Single
import lucasqrib.com.br.data.repositories.ICharactersRepository
import lucasqrib.com.br.domain.character.mappers.toCharacter
import lucasqrib.com.br.domain.character.model.Character
import lucasqrib.com.br.domain.character.usecases.IGetFavoriteCharactersUseCase

class GetFavoriteCharactersUseCase(private val charactersRepository: ICharactersRepository) :
    IGetFavoriteCharactersUseCase {
    override fun execute(): Single<List<Character>> {
        return charactersRepository.getFavoriteCharacters()
            .map { it.map { favoriteCharacter -> favoriteCharacter.toCharacter() } }
    }
}