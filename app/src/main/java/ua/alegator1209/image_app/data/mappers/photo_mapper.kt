package ua.alegator1209.image_app.data.mappers

import ua.alegator1209.image_app.core.model.Photo
import ua.alegator1209.image_app.data.model.PhotoDto

fun PhotoDto.toPhoto() = Photo(
    id = id,
    width = width,
    height = height,
    url = url,
    avgColor = avgColor,
    photographer = Photo.Photographer(
        id = photographerId,
        name = photographer,
        url = photographerUrl
    ),
    src = src
)
