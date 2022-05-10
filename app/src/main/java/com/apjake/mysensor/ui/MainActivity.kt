package com.apjake.mysensor.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.apjake.mysensor.ui.theme.MySensorTheme
import com.apjake.mysensor.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySensorTheme {
                val isDark = viewModel.isDark
                Main(isDark)
            }
        }
    }
}

@Composable
fun Main(isDark: Boolean){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                if(isDark) Color.DarkGray else Color.White
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = if(isDark) "It's dark outside" else "It's bright outside",
            color = if(isDark) Color.White else Color.DarkGray
        )
    }
}