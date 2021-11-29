package ua.alegator1209.image_app.core.model

import kotlinx.serialization.Serializable

data class Photo(
    val id: Int,
    val width: Int,
    val height: Int,
    val url: String,
    val avgColor: String,
    val photographer: Photographer,
    val src: Src,
) {
    data class Photographer(
        val id: Int,
        val name: String,
        val url: String
    )

    @Serializable
    data class Src(
        val original: String,
        val large: String,
        val large2x: String,
        val medium: String,
        val small: String,
        val portrait: String,
        val landscape: String,
        val tiny: String,
    )
}