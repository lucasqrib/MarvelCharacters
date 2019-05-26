package lucasqrib.com.br.domain.di

import lucasqrib.com.br.domain.character.usecases.IAddFavoriteCharacterUseCase
import lucasqrib.com.br.domain.character.usecases.IGetCharactersUseCase
import lucasqrib.com.br.domain.character.usecases.IGetFavoriteCharactersUseCase
import lucasqrib.com.br.domain.character.usecases.IRemoveFavoriteCharacterUseCase
import lucasqrib.com.br.domain.character.usecases.implementations.AddFavoriteCharacterUseCase
import lucasqrib.com.br.domain.character.usecases.implementations.GetCharactersUseCase
import lucasqrib.com.br.domain.character.usecases.implementations.GetFavoriteCharactersUseCase
import lucasqrib.com.br.domain.character.usecases.implementations.RemoveFavoriteCharacterUseCase
import org.koin.dsl.module

object DomainModule {
    val module = module {
        single<IGetCharactersUseCase> {
            GetCharactersUseCase(charactersRepository = get())
        }

        single<IGetFavoriteCharactersUseCase> {
            GetFavoriteCharactersUseCase(charactersRepository = get())
        }

        single<IAddFavoriteCharacterUseCase> {
            AddFavoriteCharacterUseCase(charactersRepository = get())
        }

        single<IRemoveFavoriteCharacterUseCase> {
            RemoveFavoriteCharacterUseCase(charactersRepository = get())
        }
    }
}