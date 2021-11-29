package ua.alegator1209.image_app.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class SearchResultDto(
    @SerialName("total_results")
    val totalResults: Int,

    val page: Int,

    @SerialName("per_page")
    val perPage: Int,

    val photos: List<PhotoDto>,

    @SerialName("next_page")
    val nextPage: String? = null,

    @SerialName("prev_page")
    val prevPage: String? = null,
)
