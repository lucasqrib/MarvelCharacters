package lucasqrib.com.br.marvelchallenge.characters

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterVO(
    val id: Int,
    val name: String,
    var isFavorite: Boolean = false,
    val description: String,
    val smallPhoto: String,
    val largePhoto: String
) : Parcelable