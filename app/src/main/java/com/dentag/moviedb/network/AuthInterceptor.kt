package com.dentag.moviedb.network

import com.dentag.moviedb.repository.settings.FakeSettingsRepositoryImplementation
import com.dentag.moviedb.repository.settings.SettingsRepository
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(
    private val settingsRepository: SettingsRepository = FakeSettingsRepositoryImplementation()
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val apiKey = settingsRepository.getApiKey()
        val request = chain.request().newBuilder()
        val originalHttpUrl = chain.request().url
        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("api_key", apiKey)
            .addQueryParameter("language", "ru")
            .build()
        request.url(url)
        return chain.proceed(request.build())
    }
}