package lucasqrib.com.br.data.repositories

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import lucasqrib.com.br.data.local.CharactersDAO
import lucasqrib.com.br.data.local.models.FavoriteCharacter
import lucasqrib.com.br.data.remote.api.Api
import lucasqrib.com.br.data.remote.models.responses.CharactersResponse

class CharactersRepository(val api: Api, val charactersDAO: CharactersDAO) : ICharactersRepository {
    override fun getCharacters(limit: Int, offset: Int): Observable<CharactersResponse> {
        return api.getCharacters(limit, offset)
    }

    override fun getFavoriteCharacters(): Single<List<FavoriteCharacter>> {
        return charactersDAO.getCharacters()
    }

    override fun addCharacter(character: FavoriteCharacter): Completable {
        return Completable.fromCallable { charactersDAO.insertCharacter(character) }
    }

    override fun removeCharacter(id: Int): Completable {
        return Completable.fromCallable { charactersDAO.deleteCharacterById(id) }
    }
}