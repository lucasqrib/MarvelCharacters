package lucasqrib.com.br.marvelchallenge.characters

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterVO(
    val id: String,
    val name: String,
    val isFavorite: Boolean = false,
    val photo: String = "http://i.annihil.us/u/prod/marvel/i/mg/d/d0/5269657a74350/landscape_medium.jpg"
) : Parcelable {
    companion object {
        var DIFF_CALLBACK = object : DiffUtil.ItemCallback<CharacterVO>() {
            override fun areItemsTheSame(oldItem: CharacterVO, newItem: CharacterVO): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: CharacterVO, newItem: CharacterVO): Boolean {
                return oldItem == newItem
            }
        }

    }


    override fun equals(other: Any?): Boolean {
        return other is CharacterVO && this.id == other.id
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + isFavorite.hashCode()
        result = 31 * result + photo.hashCode()
        return result
    }
}