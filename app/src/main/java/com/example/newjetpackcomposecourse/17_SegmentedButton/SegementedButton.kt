package com.example.newjetpackcomposecourse.`17_SegmentedButton`

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.DirectionsBike
import androidx.compose.material.icons.automirrored.filled.DirectionsRun
import androidx.compose.material.icons.automirrored.filled.DirectionsWalk
import androidx.compose.material.icons.filled.DirectionsBus
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material3.Icon
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.newjetpackcomposecourse.`16_SearchBar`.SearchScreen


@Composable
fun SegmentedButtonEx() {

    val selectedOption = remember {
        mutableStateListOf(false, false, false,  false)

    }

    val options = listOf("Walk", "Ride", "Drive", "Bike")

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        MultiChoiceSegmentedButtonRow {
            options.forEachIndexed { index, label ->

                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(
                        index = index,
                        count = options.size
                    ),
                    checked = selectedOption[index],
                    onCheckedChange = {
                        selectedOption[index] = !selectedOption[index]

                    },

                    icon = {
                        SegmentedButtonDefaults.Icon(selectedOption[index])
                    },
                    label = {

                        when (label) {
                            "Walk" -> Icon(
                                Icons.AutoMirrored.Filled.DirectionsWalk,
                                contentDescription = "Direction walk"
                            )

                            "Ride" -> Icon(
                                Icons.Default.DirectionsBus,
                                contentDescription = "Direction ride"
                            )

                            "Drive" -> Icon(
                                Icons.Default.DirectionsCar,
                                contentDescription = "Direction drive"
                            )

                            "Bike" -> Icon(
                                Icons.AutoMirrored.Filled.DirectionsBike,
                                contentDescription = "Direction bike"
                            )
                        }
                    }

                )

            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SearchBarPre() {
    SegmentedButtonEx()
}
