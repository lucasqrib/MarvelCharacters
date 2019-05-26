package lucasqrib.com.br.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class FavoriteCharacter(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "largePhoto")
    val largePhoto: String,
    @ColumnInfo(name = "smallPhoto")
    val smallPhoto: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "isFavorite")
    val isFavorite: Boolean
)
