package lucasqrib.com.br.domain.character.usecases.implementations

import io.reactivex.Completable
import lucasqrib.com.br.data.repositories.ICharactersRepository
import lucasqrib.com.br.domain.character.usecases.IRemoveFavoriteCharacterUseCase

class RemoveFavoriteCharacterUseCase(val charactersRepository: ICharactersRepository) :
    IRemoveFavoriteCharacterUseCase {
    override fun execute(param: Int): Completable {
        return charactersRepository.removeCharacter(param)
    }
}