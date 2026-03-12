package com.example.rockpaperscissor.ui.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun LanguageChoose(modifier: Modifier = Modifier,
                   onNext: () -> Unit) {

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(28.dp)
        ) {

            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

               var isClicked by rememberSaveable() { mutableStateOf(false) }
                val animateButton by animateColorAsState(
                    targetValue = if (isClicked) MaterialTheme.colorScheme.primary else Color.Transparent,
                    label = "buttonColor"
                )

                val textColor by animateColorAsState(
                    targetValue = if (isClicked) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onPrimaryContainer,
                    label = "textColor"
                )


                Text(
                    text = "Choose Your Preferred Language",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )

                OutlinedButton(
                    onClick = {isClicked=!isClicked
                        onNext()},
                    border = BorderStroke(
                        2.dp,
                        MaterialTheme.colorScheme.onPrimaryContainer
                    ),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = animateButton,
                        contentColor = textColor // Animate the text color too so it stays readable!
                    )
                ) {
                    Text(
                        "English",
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }

                OutlinedButton(
                    onClick = {isClicked=!isClicked
                        onNext()},
//                    colors = ButtonDefaults.outlinedButtonColors(containerColor = animateButton),
                    border = BorderStroke(
                        2.dp,
                        MaterialTheme.colorScheme.onPrimary
                    ),
                ) {
                    Text(
                        "Hindi",
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }

            }
        }
    }
}