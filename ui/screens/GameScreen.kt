package com.example.rockpaperscissor.ui.screens


import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rockpaperscissor.R
import com.example.rockpaperscissor.viewmodel.GameViewModel

@Composable
fun GameScreen(modifier: Modifier = Modifier
               ,viewModel: GameViewModel= GameViewModel(),
               onBackToHome: () -> Unit = {}) {


    val state by viewModel.state.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            val profile = if (state.playerGender == "Male") R.drawable.img_2 else R.drawable.img_3

            Image(
                painter = painterResource(profile),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .border(2.dp, MaterialTheme.colorScheme.surfaceVariant, CircleShape)
            )

            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Score: ${state.userPoints}", style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.surfaceVariant)
            }

            Text(
                text = " VS",
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.padding(end = 16.dp)
            )
            Image(
                painter = painterResource(R.drawable.img_4),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .border(2.dp, MaterialTheme.colorScheme.surfaceVariant, CircleShape)
            )
            Text(text = "Score: ${state.computerPoints}", style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.surfaceVariant)



        }

        Spacer(modifier = Modifier.weight(0.5f))


        Text(
            text = "Choose your move",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color=MaterialTheme.colorScheme.surfaceVariant
        )


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            MoveButton("🪨", "Rock") { viewModel.onPlayerMove("Rock") }
            MoveButton("📄", "Paper") { viewModel.onPlayerMove("Paper") }
            MoveButton("✂️", "Scissors") { viewModel.onPlayerMove("Scissors") }
        }

        Box(modifier = Modifier.height(70.dp), contentAlignment = Alignment.Center) {
            Text(
                text = state.roundResult,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.surfaceVariant,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun MoveButton(
    emoji: String,
    label: String,
    onClick: () -> Unit
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.9f else 1f,
        label = "buttonScale"
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(
            onClick = onClick,
            interactionSource = interactionSource,
            modifier = Modifier
                .size(90.dp)
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                },
            shape = RoundedCornerShape(16.dp) // Slightly rounded looks more modern than default
        ) {
            Text(emoji, fontSize = 30.sp)
        }
        Text(label, style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.surfaceVariant)
    }
}
