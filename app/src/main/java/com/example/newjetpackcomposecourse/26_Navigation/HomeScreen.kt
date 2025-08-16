package com.example.newjetpackcomposecourse.`26_Navigation`

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TimePickerDefaults.colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {

    Box(modifier = Modifier.fillMaxSize().padding(7.dp)) {

    Column(
        modifier = Modifier
            .fillMaxSize().padding(4.dp)
            .background(color = Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "This is the Home Screen",
            fontSize = 30.sp
        )

        Spacer(Modifier.height(25.dp))

        Button(
            onClick = {
                navController.navigate(Routes.Wishlist.route)
            },
            colors= ButtonDefaults.buttonColors(
                containerColor = Color.Red
                , contentColor = Color.White
            )
        ) {
            Text("Go to Wishlist")
        }

        Spacer(Modifier.height(25.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp))
        {
            Button(
                onClick = { navController.navigate(Routes.Cards.route) }
            ) { Text("Cards") }

            Button(onClick = {})
            { Text("Basic")
            }
        }




    }
}
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val navController = androidx.navigation.compose.rememberNavController()
    HomeScreen(navController = navController)
}
