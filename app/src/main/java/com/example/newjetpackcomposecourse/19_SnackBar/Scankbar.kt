package com.example.newjetpackcomposecourse.`19_SnackBar`

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newjetpackcomposecourse.`18_Slider`.SliderExample
import kotlinx.coroutines.launch


@Composable
fun SnackBarExample() {


    //  small  notification  inside the app

    val scope = rememberCoroutineScope()

    val snackBarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = {

            SnackbarHost(hostState = snackBarHostState)
        }, floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text(text = "Show Snackbar") },
                icon = { Icon(Icons.Filled.Image, contentDescription = "Image Icon") },
                onClick = {
                    scope.launch {
                        val result = snackBarHostState.showSnackbar(
                            message = "SnackBar Message",
                            actionLabel = "Action",
                            duration = SnackbarDuration.Indefinite
                        )
                        when (result) {
                            SnackbarResult.ActionPerformed -> {
                                //  Perform  Any action

                            }

                            SnackbarResult.Dismissed -> {
                                //  User Dismissed ||  dismissed any  action
                            }
                        }
                    }
                }
            )
        },
        content = { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp)
            ) {
                Text(text = "Tab  the Fab  to  show ths Snackbar!")
            }
        }

    )

}


@Preview(showSystemUi = true)
@Composable
fun SliderPreview() {
    SnackBarExample()
}