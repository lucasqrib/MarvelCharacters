package lucasqrib.com.br.domain.character.usecases

import lucasqrib.com.br.domain.BaseUseCase
import lucasqrib.com.br.domain.character.model.Character
import lucasqrib.com.br.domain.character.model.PageParam
import lucasqrib.com.br.domain.character.model.Query

interface IGetCharactersUseCase : BaseUseCase.ObservableWithParameter<PageParam, Query<List<Character>>>
