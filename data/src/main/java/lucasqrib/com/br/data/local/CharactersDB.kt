package lucasqrib.com.br.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import lucasqrib.com.br.data.local.models.FavoriteCharacter

@Database(entities = [FavoriteCharacter::class], version = 1)
abstract class CharactersDB() : RoomDatabase() {
    abstract fun characterDAO(): CharactersDAO

    companion object {

        @Volatile
        private var INSTANCE: CharactersDB? = null

        fun getInstance(context: Context): CharactersDB =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                CharactersDB::class.java, "Characters.db"
            ).build()
    }
}