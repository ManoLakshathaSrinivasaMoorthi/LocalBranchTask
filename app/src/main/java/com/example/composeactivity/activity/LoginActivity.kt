package com.example.composeactivity.activity

import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.composeactivity.R
import com.example.composeactivity.ui.theme.LoginScreenTheme

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Set Theme for Screen
           LoginScreenTheme {
                AppScreen()
            }
        }
    }

    @Composable
    private fun AppScreen() {

        val context = LocalContext.current
        val email = remember { mutableStateOf(TextFieldValue()) }
        val emailErrorState = remember { mutableStateOf(false) }
        val passwordErrorState = remember { mutableStateOf(false) }
        val password = remember { mutableStateOf(TextFieldValue()) }

        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp,50.dp,2.dp,4.dp)
        ) {
            Image(
                painterResource(id = R.drawable.ic_logo),
                contentDescription = "Login Image", modifier = Modifier.requiredSize(50.dp, 60.dp)
            )
            Spacer(modifier = Modifier.requiredSize(10.dp))
            Text(
                text = "Welcome to Omnicure Now,",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
        }
        Spacer(Modifier.size(20.dp))

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
            verticalArrangement = Arrangement.Center,) {
            Text(text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Black)) {
                    append("Login in to Account")
                }
            }, fontSize = 14.sp)
            Spacer(Modifier.size(16.dp))
            OutlinedTextField(
                value = email.value,
                onValueChange = {
                    if (emailErrorState.value) {
                        emailErrorState.value = false
                    }
                    email.value = it
                },
                isError = emailErrorState.value,
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Email or Phone Number")
                },
            )
            if (emailErrorState.value) {
                Text(text = "Required", color = Color.Red)
            }
            Spacer(Modifier.size(16.dp))
            val passwordVisibility = remember { mutableStateOf(true) }
            OutlinedTextField(
                value = password.value,
                onValueChange = {
                    if (passwordErrorState.value) {
                        passwordErrorState.value = false
                    }
                    password.value = it
                },
                isError = passwordErrorState.value,
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Password")
                },
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisibility.value = !passwordVisibility.value
                    }) {

                    }
                },
                visualTransformation = if (passwordVisibility.value) PasswordVisualTransformation() else VisualTransformation.None
            )
            if (passwordErrorState.value) {
                Text(text = "Required", color = Color.Red)
            }
            Spacer(Modifier.size(16.dp))
            Button(
                onClick = {
                    when {
                        email.value.text.isEmpty() -> {
                            emailErrorState.value = true
                        }
                        password.value.text.isEmpty() -> {
                            passwordErrorState.value = true
                        }
                        else -> {
                            passwordErrorState.value = false
                            emailErrorState.value = false
                            Toast.makeText(context, "Logged in successfully", Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                },
                content = {
                    Text(text = "Login", color = Color.White)
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
            )
            Spacer(Modifier.size(16.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                TextButton(onClick = {

                }) {
                    Text(text = "Register ?", color = Color.Black)
                }
            }
        }


    }


}