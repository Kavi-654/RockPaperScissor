package com.example.rockpaperscissor

import AppNavigation
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rockpaperscissor.ui.screens.GameScreen
import com.example.rockpaperscissor.ui.screens.HomeScreen
import com.example.rockpaperscissor.ui.screens.LanguageChoose
import com.example.rockpaperscissor.ui.screens.ProfileScreen
import com.example.rockpaperscissor.ui.theme.RockPaperScissorTheme
import com.example.rockpaperscissor.ui.screens.RulesScreen
import com.example.rockpaperscissor.viewmodel.GameViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RockPaperScissorTheme {

                    Scaffold(modifier = Modifier.fillMaxSize(),
                        containerColor = MaterialTheme.colorScheme.onSurfaceVariant) { innerPadding ->
                        MyApp(
                            modifier = Modifier.padding(innerPadding)
                        )

                }
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {

    AppNavigation()
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    RockPaperScissorTheme(darkTheme = false) {
        MyApp(Modifier)
    }
}


