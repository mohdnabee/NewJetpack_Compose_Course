package com.example.newjetpackcomposecourse.`4_LayoutComposable`

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//  Lazy  Column ||  to scrollable

@Composable
fun LazyColumnExample(){

    Column(
        modifier = Modifier.fillMaxSize(),
        Arrangement.Center,

    ) {
        Text("LazyColumn (prepared for the List)")

        LazyColumn(
            modifier = Modifier.fillMaxWidth().
            height(200.dp)
                .background(Color.LightGray)
        ) {

            items(100) {index ->

                Text(
                    text="Item $index in  LazyColoumn",
                    modifier = Modifier.fillMaxWidth().padding(16.dp)
                        .background(Color.White))
            }
        }
    }
}


//  lazy  Row
@Composable
fun LazyRowExample(){


        Column(
            modifier = Modifier.fillMaxSize(),
            Arrangement.Center,

            ) {
            Text("LazyRow (prepared for the List")

            LazyRow (
                modifier = Modifier.fillMaxWidth().
                height(200.dp)
                    .background(Color.LightGray)
            ) {

                items(100) {index ->

                    Text(
                        text="Item $index in  LazyColoumn",
                        modifier = Modifier.fillMaxWidth().padding(16.dp)
                            .background(Color.White))

            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun ExamplePreview() {
    LazyColumnExample()
}


