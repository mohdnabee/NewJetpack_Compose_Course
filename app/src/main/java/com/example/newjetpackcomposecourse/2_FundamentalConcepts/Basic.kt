package com.example.newjetpackcomposecourse.`2_FundamentalConcepts`

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

//  What is the Composable Function
//  composable means the below function is UI function

@Composable
fun Greeting() {
    Text("Hello, Jetpack Compose!")
}

//  to  see a UI in the preview
@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    Greeting()
}

