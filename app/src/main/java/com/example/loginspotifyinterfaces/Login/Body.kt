package com.example.loginspotifyinterfaces.Login

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/*
@Composable
fun Body(modifier: Modifier) {
    continuaCon("Google")
    continuaCon("Facebook")
    continuaCon("Apple")
}


@Composable
fun continuaCon(app : String) {
    /*
    Box(

        modifier = Modifier
            .padding(7.dp, 31.dp)
                                  // el problema está aqui
            .background(Color.Black)
            .border(1.dp, color = Color(0xFF878787), shape = CircleShape)
            .padding(7.dp, 31.dp)
            .fillMaxWidth(),

    )
    */
    Button(
        onClick = { /* Handle button click */ },
        modifier = Modifier
            .padding(7.dp, 31.dp)
            .height(48.dp)                      // el problema está aqui
            .background(Color.Black)
            .border(1.dp, color = Color(0xFF878787), shape = CircleShape)
            .padding(7.dp, 31.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White
        )
    ) {
        Text(
            text = "Continuar con $app",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Default,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(7.dp, 31.dp)
        )
    }
}

*/