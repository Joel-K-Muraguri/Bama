package com.joel.bama.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joel.bama.core.ui.theme.BamaTheme
import com.joel.bama.presentation.views.NavGraphs
import com.joel.bama.presentation.views.Settings
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BamaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DestinationsNavHost(navGraph = NavGraphs.root)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(text = "$name")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BamaTheme {
        Greeting("Android")
    }
}