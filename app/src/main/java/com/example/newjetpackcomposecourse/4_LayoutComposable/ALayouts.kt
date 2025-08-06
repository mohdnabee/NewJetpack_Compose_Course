package com.example.newjetpackcomposecourse.`4_LayoutComposable`

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout


// 1.  Column  , it allows you  to  place its children  in a vertical  sequence
// 2.  Row  , it allows you  to  place its children  in a horizontal  sequence
//3. Box , it allows you  to  place its children  in a rectangular  sequence

@Composable
fun ColumnExample() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
            .padding(15.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text("Text 1 ")
        Text("Text 2 ")
        Text("Text 3 ")
        Text("Text 4 ")
        Text("Text 5 ")

    }

}


//  row  example
@Composable
fun RowExample() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding(15.dp),

        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Text("Text 1 ")
        Text("Text 2 ")
        Text("Text 3 ")
        Text("Text 4 ")
        Text("Text 5 ")
    }
}


//  3 . box  is a blank  container  that  can  hold  other  composable

@Composable
fun BoxExample() {

    Box(
        modifier = Modifier
            .size(200.dp)
            .background(Color.Red),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(color = Color.Black)
        ) {

        }
    }


}


//  4.  Constraint Layout it is advance
//  Use only  when  needed and UI  is Complex
//  add dependence || implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")

@Composable
fun ConstraintLayoutExample() {

    Column {


        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(color = Color.LightGray)
        ) {

            val (text1, text2, text3) = createRefs()

            Text(
                "Bottom left",
                modifier = Modifier.constrainAs(text1) {
                    bottom.linkTo(parent.bottom, margin = 8.dp)
                    start.linkTo(parent.start, margin = 8.dp)
                }
            )

            Text(
                "Center left",
                modifier = Modifier.constrainAs(text2) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )


            Text(
                "Top Right ",
                modifier = Modifier.constrainAs(text3) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
            )


        }

    }


}


@Preview(showSystemUi = true)
@Composable
fun ColumnExamplePreview() {
  ConstraintLayoutExample()
}


//  Best  Practice
/*
  1.  over  Nesting
 */