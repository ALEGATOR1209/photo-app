package ua.alegator1209.image_app.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import ua.alegator1209.image_app.BuildConfig
import ua.alegator1209.image_app.data.api.AuthInterceptor
import ua.alegator1209.image_app.data.api.PexelsApi
import ua.alegator1209.image_app.data.datasource.PhotoRemoteDataSource
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun providePhotoRemoteDataSource(api: PexelsApi): PhotoRemoteDataSource {
        return PhotoRemoteDataSource(api)
    }

    @Provides
    fun providePexelsApi(retrofit: Retrofit): PexelsApi {
        return retrofit.create(PexelsApi::class.java)
    }

    @ExperimentalSerializationApi
    @Provides
    fun provideRetrofit(json: Json, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(
                json.asConverterFactory(MediaType.parse("application/json")!!)
            ).client(client)
            .build()
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor())
            .callTimeout(2L, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    fun provideJson(): Json {
        return Json {
            ignoreUnknownKeys = true
        }
    }
}
