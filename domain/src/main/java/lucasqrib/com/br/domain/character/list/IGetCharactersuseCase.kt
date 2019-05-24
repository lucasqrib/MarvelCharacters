package lucasqrib.com.br.domain.character.list

import android.arch.paging.PagedList
import lucasqrib.com.br.domain.BaseUseCase

interface IGetCharactersuseCase : BaseUseCase.FromObservable.WithParameter<PagedList<>>
