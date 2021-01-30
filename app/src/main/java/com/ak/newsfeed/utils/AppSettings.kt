package com.ak.newsfeed.utils

import android.content.Context
import android.util.Log
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.emptyPreferences
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

const val TAG = "AppSettings"
data class FilterPreferences(val appTheme: ThemeType)
class AppSettings(private val context: Context) {
    private val dataStore = context.createDataStore("user_news_preferences")
    private val appTheme: ThemeType = ThemeType.LIGHT

    val preferencesFlow = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                Log.e(TAG, "Error reading preferences", exception)
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            val appUserTheme = ThemeType.valueOf(
                preferences[PreferencesKeys.APP_THEME] ?: ThemeType.LIGHT.name
            )
            FilterPreferences(appUserTheme)
        }

    suspend fun updateUserTheme(themeType: ThemeType){
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.APP_THEME] = themeType.name
        }
    }

    private object PreferencesKeys {
        val APP_THEME = preferencesKey<String>("app_theme")
    }
}