package lucasqrib.com.br.domain.character.model

data class Character(
    val id: Int,
    val name: String,
    val description: String,
    val smallPhoto: String,
    val largePhoto: String
)