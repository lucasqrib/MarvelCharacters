package lucasqrib.com.br.domain.character.usecases.implementations

import io.reactivex.Observable
import lucasqrib.com.br.data.repositories.ICharactersRepository
import lucasqrib.com.br.domain.character.model.Character
import lucasqrib.com.br.domain.character.model.PageParam
import lucasqrib.com.br.domain.character.model.Query
import lucasqrib.com.br.domain.character.mappers.toQuery
import lucasqrib.com.br.domain.character.usecases.IGetCharactersUseCase

class GetCharactersUseCase(private val charactersRepository: ICharactersRepository) :
    IGetCharactersUseCase {
    override fun execute(param: PageParam): Observable<Query<List<Character>>> {
        return charactersRepository.getCharacters(limit = param.limit, offset = param.offset)
            .map { it.toQuery() }
    }
}