package com.example.composeactivity.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.composeactivity.R
import com.example.composeactivity.ui.theme.ComposeActivityTheme

class ActivityLocalCareProviderSignUpFirst : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeActivityTheme() {
                ProviderInputs()
            }
        }
    }

    @Composable
    private fun ProviderInputs() {

        val Firstname = remember { mutableStateOf("") }
        val lastname = remember { mutableStateOf("") }
        val email = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        val phone = remember { mutableStateOf("") }


        Box(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),) {
               Button(onClick = { /*TODO*/ }) {
                   Image(painterResource(id = R.drawable.ic_step_1), contentDescription = null,Modifier.padding(vertical = 40.dp , horizontal = 90.dp),
                   )
               }
            Spacer(modifier = Modifier.padding(horizontal = 40.dp))
                Image(painterResource(id = R.drawable.ic_step_1), contentDescription = null,Modifier.padding(vertical = 40.dp , horizontal = 90.dp),
                )
            }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.70f)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

                Text(
                    text = "Sign Up", fontSize = TextUnit.Unspecified,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        letterSpacing = TextUnit.Companion.Unspecified
                    )
                )
                Spacer(modifier = Modifier.padding(20.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    OutlinedTextField(
                        value = Firstname.value,
                        onValueChange = { Firstname.value = it },
                        placeholder = { Text(text = "Name") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )

                    OutlinedTextField(
                        value = lastname.value,
                        onValueChange = { lastname.value = it },
                        placeholder = { Text(text = "Email Address") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )

                 /*   OutlinedTextField(
                        value = phoneValue.value,
                        onValueChange = { phoneValue.value = it },
                        label = { Text(text = "Phone Number") },
                        placeholder = { Text(text = "Phone Number") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                    )

                    OutlinedTextField(
                        value = passwordValue.value,
                        onValueChange = { passwordValue.value = it },
                        label = { Text(text = "Password") },
                        placeholder = { Text(text = "Password") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        trailingIcon = {
                            IconButton(onClick = {
                                passwordVisibility.value = !passwordVisibility.value
                            }) {
                                Icon(
                                    imageVector = vectorResource(id = R.drawable.password_eye),
                                    tint = if (passwordVisibility.value) primaryColor else Color.Gray
                                )
                            }
                        },
                        visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                        else PasswordVisualTransformation()
                    )

                    OutlinedTextField(
                        value = confirmPasswordValue.value,
                        onValueChange = { confirmPasswordValue.value = it },
                        label = { Text(text = "Confirm Password") },
                        placeholder = { Text(text = "Confirm Password") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        trailingIcon = {
                            IconButton(onClick = {
                                confirmPasswordVisibility.value = !confirmPasswordVisibility.value
                            }) {
                                Icon(
                                    imageVector = vectorResource(id = R.drawable.password_eye),
                                    tint = if (confirmPasswordVisibility.value) primaryColor else Color.Gray
                                )
                            }
                        },
                        visualTransformation = if (confirmPasswordVisibility.value) VisualTransformation.None
                        else PasswordVisualTransformation()
                    )*/
                    Spacer(modifier = Modifier.padding(10.dp))
                    Button(onClick = { }, modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(50.dp)) {
                     //   Text(text = "Sign Up", fontSize = TextUnit.Companion.Sp(20))
                    }
                    Spacer(modifier = Modifier.padding(20.dp))
                    /*Text(
                        text = "Login Instead",
                        modifier = Modifier.clickable(onClick = {
                            navController.navigate("login_page"){
                                popUpTo = navController.graph.startDestination
                                launchSingleTop = true
                            }
                        })
                    )*/
                    Spacer(modifier = Modifier.padding(20.dp))

                }

            }
        }
    }





