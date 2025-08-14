package com.example.newjetpackcomposecourse.`20_Bages`

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newjetpackcomposecourse.`19_SnackBar`.SnackBarExample


//  small  pieces of information  and notification

@Composable
fun  BagesInteractiveExample(){

    var  itemCount by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,

        verticalArrangement= Arrangement.Center
    ) {

        BadgedBox(
            badge = {

                if(itemCount >0){
                    Badge(
                        containerColor = Color.Blue,
                        contentColor = Color.White
                    ){
                        Text("$itemCount")
                    }
                }

            }

        ) {
            Icon(
               imageVector = Icons.Filled.ShoppingCart,  contentDescription = "Cart Image "
            )

        }

        Button(onClick = {
            itemCount ++
        }) {
            Text(text = "Add Item")

        }
    }




}


@Preview(showSystemUi = true)
@Composable
fun SliderPreview() {
    BagesInteractiveExample()

}