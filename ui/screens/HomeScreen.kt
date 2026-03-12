package com.example.rockpaperscissor.ui.screens


import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.rockpaperscissor.R



@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNext: () -> Unit // <--- 1. Add this parameter
) {
    var animateButton by rememberSaveable() { mutableStateOf(false) }
    val buttonClr by animateColorAsState(
        if (animateButton) {
            MaterialTheme.colorScheme.onSurface
        } else {
            MaterialTheme.colorScheme.surface
        },
        label = ""
    )

    Column(
        modifier = modifier // Use the passed modifier
            .fillMaxSize()
            .padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = null,
            Modifier
                .padding(top = 80.dp)
                .size(250.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(Modifier.padding(32.dp))

        Text(
            "Rock Paper Scissor".uppercase(),
            color = MaterialTheme.colorScheme.surfaceVariant,
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(Modifier.padding(24.dp))


        OutlinedButton(
            onClick = { onNext() }, // This triggers the navigation!
            modifier = Modifier.fillMaxWidth(),
            border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
        ) {
            Text("Let's Play", style = MaterialTheme.typography.labelLarge)
        }
    }
}