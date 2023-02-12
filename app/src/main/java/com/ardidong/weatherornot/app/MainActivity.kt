package com.ardidong.weatherornot.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import com.ardidong.weatherornot.app.databinding.ActivityMainBinding
import com.ardidong.weatherornot.app.presentation.WeatherOrNotApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.observableResult.observe(this){
            binding.mainText.text = it.toString()
        }
//        setContent {
//            WeatherOrNotApp()
//        }
    }
}
