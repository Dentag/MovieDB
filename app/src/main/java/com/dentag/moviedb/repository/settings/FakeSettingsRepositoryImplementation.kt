package com.dentag.moviedb.repository.settings

class FakeSettingsRepositoryImplementation : SettingsRepository {
    private val apiKey = "274f828ad283bd634ef4fc1ee4af255f"

    override fun getApiKey(): String {
        return apiKey
    }
}