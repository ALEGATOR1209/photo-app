package ua.alegator1209.image_app.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ua.alegator1209.image_app.core.model.Photo

@Serializable
data class PhotoDto(
    val id: Int,
    val width: Int,
    val height: Int,
    val url: String,

    @SerialName("avg_color")
    val avgColor: String,

    val photographer: String,

    @SerialName("photographer_url")
    val photographerUrl: String,

    @SerialName("photographer_id")
    val photographerId: Int,

    val src: Photo.Src,
)
