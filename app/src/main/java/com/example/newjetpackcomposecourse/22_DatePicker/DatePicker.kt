package com.example.newjetpackcomposecourse.`22_DatePicker`

import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@Composable
fun DatePickerEx() {

    var selectedDate by remember { mutableStateOf<Long?>(null) }

    var showModel by remember { mutableStateOf(false) }


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = androidx.compose.ui.Alignment.Center
    ) {

        OutlinedTextField(
            value = selectedDate?.let { convertMillisToDate(it) } ?: "",
            onValueChange = {


            },
            label = {
                Text("DoB")
            },
            placeholder = {
                Text("MM/DD/YYYY")
            },
            trailingIcon = {
                Icon(Icons.Default.DateRange, contentDescription = "Select Date")

            },
            modifier = Modifier
                .fillMaxWidth()
                .pointerInput(selectedDate) {
                    awaitEachGesture {
                        awaitFirstDown(pass = PointerEventPass.Initial)
                        val upEvnet = waitForUpOrCancellation(
                            pass = PointerEventPass.Initial
                        )
                        if (upEvnet != null) {
                            showModel = true
                        }
                    }
                }
        )
    }



    if (showModel) {
        DataPickerModal(
            onDateSelected = {
                selectedDate = it

            },
            onDismiss = {
                showModel = false
            }
        )

    }


}

fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataPickerModal(

    onDateSelected: (Long?) -> Unit,
    onDismiss: () -> Unit
) {

    val datePickerState = rememberDatePickerState()
    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {

            TextButton(onClick = {
                onDateSelected(datePickerState.selectedDateMillis)
                onDismiss
            }) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    ) {
        DatePicker(state = datePickerState)
    }

}

@Preview(showSystemUi = true)
@Composable
fun DatePickerPreview() {
    DatePickerEx()
}