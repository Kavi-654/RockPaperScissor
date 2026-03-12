package com.example.rockpaperscissor.ui.screens

//import android.R
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.rockpaperscissor.R
import com.example.rockpaperscissor.viewmodel.GameViewModel
@Composable
fun ProfileScreen(modifier: Modifier =Modifier,
                  viewModel: GameViewModel,
                  onNext: () -> Unit)
{

    // In your ProfileScreen.kt
    var nickname by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("None") } // "Male" or "Female"

    var isClicked by rememberSaveable() { mutableStateOf(false) }
    var showDialog by rememberSaveable() {mutableStateOf(false) }
    val animateButton by animateColorAsState(
        targetValue = if (isClicked) MaterialTheme.colorScheme.primary else Color.Transparent,
        label = "buttonColor"
    )
    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
                showDialog = false
            },

            title = {
                Text("🎮 Let's Play!")
            },
            text = {
                Text(
                    "Victory begins in the mind.\n" +
                            "Ready to crush the computer?",
                    color = MaterialTheme.colorScheme.surfaceVariant
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showDialog = false
                        onNext()
                        // 👉 navigate to game screen here
                    }
                ) {
                    Text("PLAY", color = MaterialTheme.colorScheme.surfaceVariant)
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showDialog = false
                    }
                ) {
                    Text("Cancel",color= MaterialTheme.colorScheme.surfaceVariant)
                }
            }
        )
    }

    Column(Modifier.padding(top=250.dp,start=70.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        ) {
        // 1. Nickname Input
        OutlinedTextField(
            value = nickname,
            onValueChange = { nickname = it },
            label = { Text("Enter Nickname") },
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.onSurfaceVariant,
                unfocusedContainerColor = MaterialTheme.colorScheme.onSurface,
                cursorColor = MaterialTheme.colorScheme.onPrimary,


            ),

        )

        Spacer(Modifier.height(20.dp))

        // 2. Gender Selection Row
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            ProfileOptionButton(
                label = "Male",
                isSelected = selectedGender == "Male",
                onClick = { selectedGender = "Male" }
            )
            ProfileOptionButton(
                label = "Female",
                isSelected = selectedGender == "Female",
                onClick = { selectedGender = "Female" }
            )





        }

        Spacer(Modifier.height(20.dp))

        OutlinedButton(onClick = {isClicked=!isClicked
            viewModel.saveProfile(nickname,selectedGender)
            showDialog=true},
            colors = ButtonDefaults.outlinedButtonColors(containerColor = animateButton)) {
            Text("Continue",
                color = MaterialTheme.colorScheme.surfaceVariant)
        }




    }
}

@Composable
fun ProfileOptionButton(label: String, isSelected: Boolean, onClick: () -> Unit) {
    // Determine which image to show based on the label
    val imageRes = if (label == "Male") {
        R.drawable.img_2 // Replace with your male image name
    } else {
        R.drawable.img_3 // Replace with your female image name
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable { onClick() } // Makes the whole column clickable
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = label,
            modifier = Modifier
                .size(100.dp)
                // This adds a border if the user selects this gender!
                .border(
                    width = if (isSelected) 3.dp else 0.dp,
                    color = if (isSelected) MaterialTheme.colorScheme.surfaceVariant else Color.Transparent,
                    shape = CircleShape
                )
                .clip(CircleShape)
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            color = if (isSelected) MaterialTheme.colorScheme.surfaceVariant else MaterialTheme.colorScheme.onPrimary
        )
    }
}