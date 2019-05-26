package lucasqrib.com.br.data.remote.models.responses

import com.google.gson.annotations.SerializedName

data class CharactersResponse(
        @SerializedName("code") val status : Int,
        @SerializedName("data") val dataResponse: DataResponse
)