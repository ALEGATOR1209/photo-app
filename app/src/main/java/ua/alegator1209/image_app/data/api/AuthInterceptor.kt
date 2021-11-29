package ua.alegator1209.image_app.data.api

import okhttp3.Interceptor
import okhttp3.Response
import ua.alegator1209.image_app.BuildConfig

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val old = chain.request()
        val new = old.newBuilder()
            .addHeader("Authorization", BuildConfig.API_TOKEN)
            .build()

        return chain.proceed(new)
    }
}
