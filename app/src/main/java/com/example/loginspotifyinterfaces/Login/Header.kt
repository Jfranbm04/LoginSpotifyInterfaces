package com.example.loginspotifyinterfaces.Login

import android.graphics.Typeface
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.util.PatternsCompat
import com.example.loginspotifyinterfaces.R



@Composable
fun Header(modifier: Modifier) {
    logoSpotify()

}

@Composable
fun logoSpotify() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Añade tu imagen con el recurso correspondiente o la ruta de la imagen
        Image(
            painter = painterResource(id = R.drawable.logospotify),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp) // Tamaño de la imagen

        )

        Spacer(modifier = Modifier.height(30.dp))
        iniciaSesion()
        Spacer(modifier = Modifier.height(20.dp))
        Body()
        Spacer(modifier = Modifier.height(20.dp))
        // Divider con padding
        Divider(
            color = Color.Gray,
            modifier = Modifier
                .padding(vertical = 8.dp)
                .height(0.5.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        correoContraseña()


    }
}

@Composable
fun correoContraseña(){
    var email by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }
    var isLoginEnable by rememberSaveable {
        mutableStateOf(false)
    }

    Column() {
        Email(email) {
            email = it
            if (password.length > 0 && email.length > 0 && isValidEmail(email))
                isLoginEnable = true
            else
                isLoginEnable = false
        }
        Spacer(modifier = Modifier.size(4.dp))
        Password(password) {
            password = it
            if (password.length > 0 && email.length > 0 && isValidEmail(email))
                isLoginEnable = true
            else
                isLoginEnable = false
        }
        Spacer(modifier = Modifier.size(16.dp))
        LoginButton(isLoginEnable)
        Spacer(modifier = Modifier.size(16.dp))

    }


}

@Composable
fun LoginButton(loginEnable: Boolean) {
    Button(
        onClick = { /*TODO*/ }, enabled = loginEnable,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp),
        colors = ButtonDefaults.buttonColors(
            disabledContentColor = Color.White,
            contentColor = Color.White,
            containerColor = Color(0xFF00AC07),
            disabledContainerColor = Color(0xFF00AC07)

        )
    ) {
        Text(text = "Iniciar Sesion",
        color = Color.Black,
            fontSize = 16.sp)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Password(password: String, onTextChanged: (String) -> Unit) {
    var showPassword by rememberSaveable {
        mutableStateOf(false)
    }


    TextField(
        value = password,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black),

        trailingIcon = {
            val imagen = if (showPassword) {
                com.google.android.material.R.drawable.design_ic_visibility_off
            } else {
                com.google.android.material.R.drawable.design_ic_visibility
            }


            Icon(
                painter = painterResource(id = imagen),
                contentDescription = "View",
                modifier = Modifier.clickable { showPassword = !showPassword }
            )
        },

        placeholder = { Text(text = "Contraseña") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB2B2B2),
            containerColor = Color(0xFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,  // quita linea de abajo
            unfocusedIndicatorColor = Color.Transparent


        ),
        visualTransformation = if (showPassword) {
            VisualTransformation.None

        } else {
            PasswordVisualTransformation()
        }


    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Email(email: String, onTextChanged: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier
            .fillMaxWidth(),
        placeholder = { Text(text = "Email o nombre de usuario") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB2B2B2),
            containerColor = Color(0xFFFAFAFA),


        )
    )
}

@Composable
fun iniciaSesion() {
    Text(
        text = "Inicia sesión en Spotify",
        modifier = Modifier

            .background(color = Color.Black) // Ejemplo de color de fondo
            .border(1.dp, color = Color.Black) // Ejemplo de borde
            .fillMaxWidth(),
        fontSize = 28.sp, // Tamaño de fuente
        fontWeight = FontWeight.ExtraBold,
        //fontFamily = FontFamily(Typeface.DEFAULT_BOLD),
        color = Color.White // Color del texto

    )

}

fun isValidEmail(email: String): Boolean {
    return PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
}
@Composable
fun Body() {
    Row(Modifier.fillMaxWidth()){
    continuaCon("Google")
    }
    Row(Modifier.fillMaxWidth()){
        continuaCon("Facebook")
    }
    Row(Modifier.fillMaxWidth()){
        continuaCon("Apple")
    }
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

            .padding(4.dp)        // Separa los botones
            .border(1.dp, color = Color(0xFF878787), shape = CircleShape)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Color.Black
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
        )
    }
}

