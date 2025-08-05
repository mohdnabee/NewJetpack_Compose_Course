package com.example.newjetpackcomposecourse.`3_CoreComponents`

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview

// 2:50
@Composable
fun PartiallySelectableText(){

    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        SelectionContainer {

            Column {
                // vertically  align
                Text("This Is a text can  be selectable ")
                Text("This is  one two ")
                Text("Software Engineering")
                DisableSelection {
                    // jo  text  select  nhi  ho ga
                    Text("This is not selectable one")
                    Text("This is not selectable text ")

                }
            }
        }
    }

}



@Composable
fun AnnotatedStringWithListenerSample(){

    //  link add karege text  me
    val  uriHandler =  LocalUriHandler.current

    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(

            buildAnnotatedString {
                append("Naruto  wallpaper  4k  downlod !! ")
                val link = LinkAnnotation.Url(
                    "https://4kwallpapers.com/search/?q=naruto",

                    TextLinkStyles(

                        SpanStyle(
                            color = Color.Green
                        )
                    )
                ) {
                    val url = (it as LinkAnnotation.Url).url
                    uriHandler.openUri(url)

                }
                withLink(link) {
                    append("Click Here")
                }
            }
        )

    }
}



@Preview(showSystemUi = true)
@Composable
fun PartiallySelectableTextPreview(){
   // PartiallySelectableText()
    AnnotatedStringWithListenerSample()
}