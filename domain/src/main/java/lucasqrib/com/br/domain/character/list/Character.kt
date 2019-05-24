package lucasqrib.com.br.domain.character.list

data class Character(
    val id: String,
    val name: String,
    val isFavorite: Boolean = false,
    val photo: String
){
    companion object{
        fun fromResponse()
    }
}