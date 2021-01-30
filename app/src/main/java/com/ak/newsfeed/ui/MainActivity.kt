package com.ak.newsfeed.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.ak.newsfeed.R
import com.ak.newsfeed.databinding.ActivityMainBinding
import com.ak.newsfeed.utils.AppSettings
import com.ak.newsfeed.utils.FilterPreferences
import com.ak.newsfeed.utils.ThemeType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val appSettings = AppSettings(this)
        applyAppTheme(appSettings.preferencesFlow)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()
    }

    private fun applyAppTheme(preferencesFlow: Flow<FilterPreferences>) {
        lifecycleScope.launch {
            when(preferencesFlow.first().appTheme){
                ThemeType.LIGHT -> setTheme(R.style.AppTheme)

                ThemeType.DARK -> setTheme(R.style.DarkTheme)

                ThemeType.AMOLED -> setTheme(R.style.DarkTheme)

                else -> setTheme(R.style.AppTheme)
            }
        }
    }

    private fun setupNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        NavigationUI.setupWithNavController(binding.bottomNavigation, navHostFragment.navController)
    }
}
