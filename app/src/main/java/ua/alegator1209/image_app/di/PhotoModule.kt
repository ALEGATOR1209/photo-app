package ua.alegator1209.image_app.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import ua.alegator1209.image_app.core.datasource.PhotoDataSource
import ua.alegator1209.image_app.data.datasource.PhotoRemoteDataSource

@Module
@InstallIn(ActivityComponent::class)
abstract class PhotoModule {
    @Binds
    abstract fun bindPhotoDataSource(remote: PhotoRemoteDataSource): PhotoDataSource
}
