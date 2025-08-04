package com.example.newjetpackcomposecourse.`3_CoreComponents`

import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import com.example.newjetpackcomposecourse.R

@Composable
fun SimpleText(){
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ){
        Text("Hello  Jetpack  compose!!", color = Color.Black,
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline,
            style =TextStyle(shadow = Shadow(color = Color.Green, blurRadius = 20f))
        )
    }

}


@Composable
fun ColorFullText(){
    val rainbowColors =  listOf(
        Color.Red,
        Color.Yellow,
        Color.Green,
        Color.Cyan,
        Color.Magenta,
        Color.Blue,
    )

    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(
            text = buildAnnotatedString {
                append("Do  not allow people to your shine \n ")
                withStyle(
                    SpanStyle(
                        brush = Brush.linearGradient(
                            colors = rainbowColors
                        )
                    )
                ) {
                    
                    append("because they  are blinded.")
                }
                append("\n tell  them  to put some sunglasses on")
            }
        )
    }
}


@Composable
fun  ScrollableText(){

    Box(
        modifier = Modifier.fillMaxSize(), Alignment.Center
    ){
        Text("Hey this is a scrollable text example using a jetpack compose(KOTLIN) !!!",
            //maxLines = 2,
            //overflow = TextOverflow.Ellipsis,
          modifier = Modifier.basicMarquee(),
            fontSize = 50.sp,

        )


    }

}




@Preview(showSystemUi = true)
@Composable
fun SimpleTextPreview(){
    ScrollableText()

}
