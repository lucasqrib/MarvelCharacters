package lucasqrib.com.br.data.remote.models.responses

import com.google.gson.annotations.SerializedName

data class ThumbnailResponse(
    @SerializedName("path") val path: String,
    @SerializedName("extension") val extension: String
)