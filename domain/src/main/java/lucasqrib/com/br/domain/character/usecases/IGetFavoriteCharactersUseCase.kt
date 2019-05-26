package lucasqrib.com.br.domain.character.usecases

import lucasqrib.com.br.domain.BaseUseCase
import lucasqrib.com.br.domain.character.model.Character

interface IGetFavoriteCharactersUseCase : BaseUseCase.Single<List<Character>>
