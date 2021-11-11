package com.example.composeactivity.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeactivity.R
import com.example.composeactivity.ui.theme.ComposeActivityTheme

class ActivityLocalCareProviderSignUpFirst : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeActivityTheme {
                ProviderInputs()
            }
        }
    }

    @Composable
    private fun ProviderInputs() {

        val firstname = remember { mutableStateOf("") }
        val lastname = remember { mutableStateOf("") }
        val email = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        val phone = remember { mutableStateOf("") }


        Row(
            modifier = Modifier.fillMaxSize()
                .padding(1.dp), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Image(painterResource(id = R.drawable.ic_back_arrow), contentDescription = null)
            }
            Spacer(modifier = Modifier.padding(horizontal = 40.dp))
            Image(
                painterResource(id = R.drawable.ic_step_1), contentDescription = null,
                Modifier.padding(30.dp, 20.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier.padding(15.dp, 60.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Sign Up as Local Care Provider", fontSize = TextUnit.Unspecified,
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                OutlinedTextField(
                    value = firstname.value,
                    onValueChange = { firstname.value = it },
                    placeholder = { Text(text = "First name") }, singleLine = true,
                    modifier = Modifier.fillMaxWidth(1f)
                )

                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = lastname.value,
                    onValueChange = { lastname.value = it },
                    placeholder = { Text(text = "Last name") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(1f)
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = email.value,
                    onValueChange = { email.value = it },
                    placeholder = { Text(text = "Email or Phone Number") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(1f)
                )
                Spacer(modifier = Modifier.height(20.dp))

                OutlinedTextField(
                    value = password.value,
                    onValueChange = { password.value = it },
                    placeholder = { Text(text = "Password") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(1f),
                    trailingIcon = {
                        IconButton(onClick = {}) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_visibility),
                                contentDescription = ""
                            )
                        }
                    },

                    )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = phone.value,
                    onValueChange = { phone.value = it },
                    placeholder = { Text(text = "Phone Number") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(1f),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = "Localized description"
                        )
                    }
                )


                Spacer(modifier = Modifier.padding(50.dp))
                Button(
                    onClick = { }, modifier = Modifier
                        .fillMaxWidth(1f)
                        .height(50.dp)
                ) {
                    Text(text = "Next", fontSize = 14.sp)
                }

                Spacer(modifier = Modifier.padding(10.dp))
                Row(Modifier.padding(30.dp), verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Already have account?")
                    Spacer(modifier = Modifier.padding(horizontal = 2.dp))
                    TextButton(onClick = { /* Do something! */ }) {
                        Text("LOG IN", fontSize = 14.sp)
                    }
                }

            }
        }
    }
    }





