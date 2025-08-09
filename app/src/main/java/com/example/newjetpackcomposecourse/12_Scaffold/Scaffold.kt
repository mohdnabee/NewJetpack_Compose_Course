package com.example.newjetpackcomposecourse.`12_Scaffold`

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//  scaffold
/*
This is an  example of a scaffold .  It uses the
Scaffold composable's parameters to  create a
screen  with  a simple top  app  bar  ,  bottom  app, bar ,
and floating action  button


It  also  contains some basic inner  content  , such  as
this text.

You have pressed the Floating action button 4 times .

 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  ScaffoldExample(){

    var  presses by remember { mutableStateOf(0) }

    Scaffold(

        topBar = {
            TopAppBar(
                colors = TopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                    scrolledContainerColor = MaterialTheme.colorScheme.surfaceContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.primaryContainer,
                    actionIconContentColor = MaterialTheme.colorScheme.surface,
                ),
                title = {
                    Text("Top app  bar  ")
                }
            )
        },
        bottomBar = {

            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,

            ) {

                Text(
                    text = "Bottom app  Bar",
                    modifier = Modifier.padding(16.dp),
                    textAlign = TextAlign.Center
                )
            }

        },

        floatingActionButton = {
            FloatingActionButton({presses ++}) {
                Text("I' ve been  clicked $presses times")
            }
        }

    ) {innerPadding ->

//  ui  make inside the scaffold

        Column (
            modifier = Modifier.padding(innerPadding)

        ){
            Text("This is an  example of a scaffold .  It uses the Scaffold composable's parameters to  create a screen  with  a simple top  app  bar  ,  bottom  app, bar , and floating action  button",
                fontSize = 18.sp
            )
        }

    }

}

@Preview(showSystemUi = true)
@Composable
fun  ScaffoldPreview(){
    ScaffoldExample()
}
