package com.example.newjetpackcomposecourse.`3_CoreComponents`

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

//  filled Button
@Composable
fun  FilledButtonSample(){
    val  context =  LocalContext.current

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){


    Button(onClick = {
        Toast.makeText(context,"Button is Clicked",Toast.LENGTH_SHORT).show()
    }) {

        Text("Filled Button ")

    }
    }

}


// 2.  Tonal  Button   using for add to card and signin

@Composable
fun  TonalButtonSample(){
    val  context =  LocalContext.current

    Box(modifier = Modifier.fillMaxSize(),
        Alignment.Center) {


        FilledTonalButton(
            onClick = {
                Toast.makeText(context,"Tonal Button is Clicked",Toast.LENGTH_SHORT).show()
            }
        ) {

            Text("Tonal Button ")

        }
    }
}

//  3.  Outlined Button
@Composable
fun  OutlinedButtonSample(){

    val  context =  LocalContext.current

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

        //  using a cancel and back
        OutlinedButton(
            onClick = {
                Toast.makeText(context,"Outlined Button is Clicked",Toast.LENGTH_SHORT).show()
            }
        ) {
            Text("Outlined Button ")
        }
    }
}


// 4. Elevated Button

@Composable
fun  ElevatedButtonSample(){

    val  context =  LocalContext.current

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){


        ElevatedButton(
            onClick = {

            }
        ) {
            Text("Elevated Button ")
        }

    }
}


//  5.  Text Button
@Composable
fun  TextButtonSample(){

    val  context =  LocalContext.current

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

        TextButton(
            onClick = {}
        ) {
            Text("Text Button ")
        }

    }
}


@Preview(showSystemUi = true)
@Composable
fun FilledButtonSamplePreview(){
   TextButtonSample()
}
