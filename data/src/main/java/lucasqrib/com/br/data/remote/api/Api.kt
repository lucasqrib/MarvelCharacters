package lucasqrib.com.br.data.remote.api

import io.reactivex.Observable
import lucasqrib.com.br.data.remote.models.responses.CharactersResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface Api {
    @GET("characters")
    fun getCharacters(@Query("limit") limit: Int, @Query("offset") offset: Int): Observable<CharactersResponse>

}