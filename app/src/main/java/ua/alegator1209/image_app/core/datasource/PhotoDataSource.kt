package ua.alegator1209.image_app.core.datasource

import kotlinx.coroutines.flow.Flow
import ua.alegator1209.image_app.core.model.Photo

interface PhotoDataSource {
    suspend fun search(
        query: String,
        page: Int = 1,
        perPage: Int = 15
    ): Flow<List<Photo>>
}
