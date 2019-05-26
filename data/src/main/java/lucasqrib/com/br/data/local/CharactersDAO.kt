package lucasqrib.com.br.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable
import io.reactivex.Single
import lucasqrib.com.br.data.local.models.FavoriteCharacter

@Dao
interface CharactersDAO {

    @Query("SELECT * FROM characters WHERE id = :id")
    fun getCharacterById(id: Int): Flowable<FavoriteCharacter>

    @Query("SELECT * FROM characters")
    fun getCharacters(): Single<List<FavoriteCharacter>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCharacter(character: FavoriteCharacter)

    @Query("DELETE FROM characters WHERE id = :id")
    fun deleteCharacterById(id: Int)
}