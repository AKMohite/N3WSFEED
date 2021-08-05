package com.ak.newsfeed.ui.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope

import com.ak.newsfeed.R
import com.ak.newsfeed.databinding.FragmentSettingsBinding
import com.ak.newsfeed.utils.AppSettings
import com.ak.newsfeed.utils.ThemeType
import kotlinx.coroutines.flow.first

/**
 * A simple [Fragment] subclass.
 */
class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private lateinit var binding: FragmentSettingsBinding
    private var appSettings: AppSettings? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsBinding.bind(view)

        appSettings = AppSettings(requireContext())

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {

            when(appSettings?.preferencesFlow?.first()?.appTheme){
                ThemeType.LIGHT -> binding.rbLight.isChecked = true

                ThemeType.DARK -> binding.rbDark.isChecked = true

                ThemeType.AMOLED -> binding.rbAmoled.isChecked = true

                else -> binding.rbLight.isChecked = true
            }
        }

        binding.rgTheme.setOnCheckedChangeListener { _, checkedId ->
            viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                when(checkedId){
                    R.id.rb_light -> appSettings?.updateUserTheme(ThemeType.LIGHT)

                    R.id.rb_dark -> appSettings?.updateUserTheme(ThemeType.DARK)

                    R.id.rb_amoled -> appSettings?.updateUserTheme(ThemeType.AMOLED)

                    else -> appSettings?.updateUserTheme(ThemeType.LIGHT)
                }

//                TODO apply theme
            }
        }
    }

}
