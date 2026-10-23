
package com.example.lab_7

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.runtime.snapshots.SnapshotStateList

@Composable
fun UpcomingRacesScreen(
    navController: NavController,
    races: SnapshotStateList<String>
) {
    var location by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.testTag("backButton")
        ) {
            Text("Back")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Upcoming Races",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                value = location,
                onValueChange = {
                    location = it
                },
                label = {
                    Text("Race Location")
                },
                modifier = Modifier
                    .weight(1f)
                    .testTag("locationInput")
            )

            Button(
                onClick = {
                    if (location.isNotBlank()) {
                        races.add(location.trim())
                        location = ""
                    }
                },
                modifier = Modifier.testTag("addRaceButton")
            ) {
                Text("Add")
            }
        }

        LazyColumn {
            items(races) { race ->
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = race,
                    fontSize = 24.sp
                )
            }
        }
    }
}
