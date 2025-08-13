package com.example.newjetpackcomposecourse.`18_Slider`

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun  SliderExample(){

    var  sliderPostion by remember {
        mutableStateOf(0f)
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
    ) {
        Slider(
            value = sliderPostion,
            onValueChange = {
                sliderPostion =  it
            },
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.secondary,
                activeTrackColor =  MaterialTheme.colorScheme.secondary,
                inactiveTrackColor =  MaterialTheme.colorScheme.secondaryContainer,
            ),
            steps = 10,
            valueRange = 0f..50f
        )
        Text(text = sliderPostion.toString())
    }


}


@Preview(showSystemUi = true)
@Composable
fun SliderPreview(){
    SliderExample()
}