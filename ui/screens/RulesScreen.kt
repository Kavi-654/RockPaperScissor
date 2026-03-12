package com.example.rockpaperscissor.ui.screens

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun RulesScreen(modifier: androidx.compose.ui.Modifier.Companion,
                onNext:() ->Unit)
{
        var showRulesDialog by remember { mutableStateOf(true) }
    var currentRuleIndex by remember { mutableStateOf(0) }

    val conditions = listOf(
        "Rock beats Scissors. Scissors beats Paper. Paper beats Rock. It’s the universal law of the game!",
        "You’re playing against a computer. It doesn't have feelings, but it is unpredictable.",
        "Winning a round gives you 1 point. A draw gives 0 points to both. Highest score at the end wins.",
        "Once you tap a move, there’s no undoing it. Make sure your finger doesn't slip!",
        "The game ends exactly when the round limit is reached. Win more rounds than the CPU to be the champ."
    )

    val titles = listOf(
        "The Classic Loop 🔄",
        "Know Your Opponent",
        "Victory by Points",
        "Locked In",
        "The Ultimate Goal"
    )

    if (showRulesDialog) {

        AlertDialog(
            onDismissRequest = { },

            title = {
                Text(text = titles[currentRuleIndex],
                    color = MaterialTheme.colorScheme.onPrimaryContainer)
            },

            text = {
                Text(
                    text = conditions[currentRuleIndex],
                    color = MaterialTheme.colorScheme.surfaceVariant
                )
            },

            confirmButton = {

                // NEXT or START button
                if (currentRuleIndex < conditions.size - 1) {
                    TextButton(
                        onClick = {
                            currentRuleIndex++
                        }
                    ) {
                        Text("Next",
                            color = MaterialTheme.colorScheme.onPrimary)
                    }
                } else {
                    TextButton(
                        onClick = {
                            showRulesDialog = false
//                            begin()
                            onNext()

                        }
                    ) {
                        Text("Start",
                            color = MaterialTheme.colorScheme.onPrimary)
                    }
                }
            },

            dismissButton = {

                if (currentRuleIndex > 0) {
                    TextButton(
                        onClick = {
                            currentRuleIndex--
                        }
                    ) {
                        Text("Previous",
                            color = MaterialTheme.colorScheme.onPrimary)
                    }
                }
            }
        )
    }

}