package lucasqrib.com.br.domain.character.usecases.implementations

import io.reactivex.Completable
import lucasqrib.com.br.data.repositories.ICharactersRepository
import lucasqrib.com.br.domain.character.mappers.toFavoriteCharacter
import lucasqrib.com.br.domain.character.model.Character
import lucasqrib.com.br.domain.character.usecases.IAddFavoriteCharacterUseCase

class AddFavoriteCharacterUseCase(private val charactersRepository: ICharactersRepository) :
    IAddFavoriteCharacterUseCase {
    override fun execute(param: Character): Completable {
        return charactersRepository.addCharacter(param.toFavoriteCharacter())
    }


}