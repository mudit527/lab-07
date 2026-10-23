
package com.example.lab_7

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DriversScreen(
    navController: NavController,
    drivers: SnapshotStateList<String>
) {
    var driverName by remember {
        mutableStateOf("")
    }

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

        Text(text = "FormulaZero Drivers")

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                value = driverName,
                onValueChange = {
                    driverName = it
                },
                label = {
                    Text("Driver Name")
                },
                modifier = Modifier
                    .weight(1f)
                    .testTag("driverInput")
            )

            Button(
                onClick = {
                    if (driverName.isNotBlank()) {
                        drivers.add(driverName.trim())
                        driverName = ""
                    }
                },
                modifier = Modifier.testTag("addDriverButton")
            ) {
                Text("Add")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                drivers.clear()
            },
            modifier = Modifier.testTag("clearDriversButton")
        ) {
            Text("Clear")
        }

        LazyColumn {
            items(drivers) { driver ->
                Text(
                    text = driver,
                    modifier = Modifier.padding(vertical = 6.dp)
                )
            }
        }
    }
}
