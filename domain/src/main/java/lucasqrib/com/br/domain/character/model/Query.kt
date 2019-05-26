package lucasqrib.com.br.domain.character.model

data class Query<T>(
    val offset: Int,
    val results: T
)