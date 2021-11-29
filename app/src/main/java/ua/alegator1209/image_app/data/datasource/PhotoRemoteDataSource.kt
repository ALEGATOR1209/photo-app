package ua.alegator1209.image_app.data.datasource

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ua.alegator1209.image_app.core.datasource.PhotoDataSource
import ua.alegator1209.image_app.core.model.Photo
import ua.alegator1209.image_app.data.api.PexelsApi
import ua.alegator1209.image_app.data.mappers.toPhoto
import ua.alegator1209.image_app.data.model.PhotoDto

class PhotoRemoteDataSource(
    private val api: PexelsApi,
) : PhotoDataSource {
    override suspend fun search(
        query: String,
        page: Int,
        perPage: Int
    ): Flow<List<Photo>> = flow {
        val photos = api.search(query, page, perPage)
            .photos
            .map(PhotoDto::toPhoto)

        emit(photos)
    }
}
