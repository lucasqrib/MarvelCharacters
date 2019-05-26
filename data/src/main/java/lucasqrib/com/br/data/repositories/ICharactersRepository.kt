package lucasqrib.com.br.data.repositories

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import lucasqrib.com.br.data.local.models.FavoriteCharacter
import lucasqrib.com.br.data.remote.models.responses.CharactersResponse

interface ICharactersRepository {

    fun getCharacters(limit: Int, offset: Int): Observable<CharactersResponse>
    fun getFavoriteCharacters(): Single<List<FavoriteCharacter>>
    fun addCharacter(character: FavoriteCharacter): Completable
    fun removeCharacter(id: Int): Completable
}