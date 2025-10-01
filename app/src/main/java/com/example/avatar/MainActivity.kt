package com.example.avatar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.avatar.ui.theme.AvatarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AvatarTheme {
                AvatarScreen()
            }
        }
    }
}

@Composable
fun AvatarScreen() {
    // state untuk checklist
    var showBrow by remember { mutableStateOf(true) }
    var showEye by remember { mutableStateOf(true) }
    var showNose by remember { mutableStateOf(true) }
    var showMouth by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Avatar
        Box(modifier = Modifier.size(400.dp)) {
            // Kepala
            Image(
                painter = painterResource(R.drawable.head),
                contentDescription = "Head",
                modifier = Modifier.matchParentSize()
            )

            if (showBrow) {
                Image(
                    painter = painterResource(R.drawable.eyebrow),
                    contentDescription = "Eyebrow",
                    modifier = Modifier
                        .size(195.dp)
                        .offset(x = 93.dp, y = 70.dp)
                )
            }

            if (showEye) {
                Image(
                    painter = painterResource(R.drawable.eyes),
                    contentDescription = "Eyes",
                    modifier = Modifier
                        .size(175.dp)
                        .offset(x = 103.dp, y = 110.dp)
                )
            }

            if (showNose) {
                Image(
                    painter = painterResource(R.drawable.nose),
                    contentDescription = "Nose",
                    modifier = Modifier
                        .size(50.dp)
                        .offset(x = 165.dp, y = 210.dp)
                )
            }

            if (showMouth) {
                Image(
                    painter = painterResource(R.drawable.mouth),
                    contentDescription = "Mouth",
                    modifier = Modifier
                        .size(75.dp)
                        .offset(x = 155.dp, y = 245.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Checklist baris horizontal
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ChecklistItem("Brow", showBrow) { showBrow = it }
            ChecklistItem("Eye", showEye) { showEye = it }
            ChecklistItem("Nose", showNose) { showNose = it }
            ChecklistItem("Mouth", showMouth) { showMouth = it }
        }
    }
}

@Composable
fun ChecklistItem(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 1.dp)
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors()
        )
        Text(text = label)
    }
}

@Preview(showBackground = true)
@Composable
fun AvatarPreview() {
    AvatarTheme {
        AvatarScreen()
    }
}
