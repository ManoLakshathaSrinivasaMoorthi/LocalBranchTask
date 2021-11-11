package com.example.composeactivity.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeactivity.R

class ActivityLocalCareProviderSignUpSecond : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                AppFields()
            }

        }
    }

    @Composable
    private fun AppFields() {
        Column(modifier = Modifier.padding(3.dp)) {
            Tittles()
            Spacer(modifier = Modifier.requiredSize(1.dp))
            Contents()
            Spacer(modifier = Modifier.requiredSize(80.dp))
            SubmitButton()
        }

    }


    @Composable
    private fun Tittles() {
        Row(modifier = Modifier.padding(1.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            IconButton(onClick = { }) {
                Image(painterResource(id = R.drawable.ic_back_arrow), contentDescription = null)
            }
            Spacer(modifier = Modifier.padding(horizontal = 80.dp))
            Image(
                painterResource(id = R.drawable.ic_step_2),
                contentDescription = null,
                Modifier.padding(30.dp, 20.dp)
            )
        }
    }

    @Composable
    private fun Contents() {
        val providers = remember { mutableStateOf("") }
        val npiNumber = remember { mutableStateOf("") }
        val hospitallist = remember { mutableStateOf("") }

        Column(Modifier.padding(20.dp)) {
            Text(text = "Signup as Local Care Provider ", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(modifier = Modifier.padding(10.dp))

            Column(horizontalAlignment = Alignment.Start, modifier = Modifier.fillMaxWidth(2f)) {
                OutlinedTextField(value = providers.value,
                    onValueChange = { providers.value = it },
                    placeholder = { Text(text = "Select Provider") }, singleLine = true,
                    modifier = Modifier.fillMaxWidth(1f),
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_user),
                            contentDescription = ""
                        )
                    })

                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = npiNumber.value,
                    onValueChange = { npiNumber.value = it },
                    placeholder = { Text(text = "Npi Number") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(1f),
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_document),
                            contentDescription = ""
                        )
                    }
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = hospitallist.value,
                    onValueChange = { hospitallist.value = it },
                    placeholder = { Text(text = "Select Hospital") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(1f),
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_location),
                            contentDescription = ""
                        )
                    }
                )
                Spacer(modifier = Modifier.height(3.dp))
                Row(Modifier.padding(5.dp), verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back_arrow),
                            contentDescription = ""
                        )
                    }
                    Spacer(modifier = Modifier.padding(horizontal = 1.dp))
                    Text(text = "By signing up you agree to Omnicure Now Terms & Conditions")
                }


            }
        }
    }
        @Composable
        private fun SubmitButton() {

            Button(onClick = {},Modifier.fillMaxWidth(1f).padding(10.dp)) {
                Text(text = "Verify account")
            }
            Row(Modifier.padding(30.dp),verticalAlignment = Alignment.CenterVertically) {
                Text(text="Already have account?")
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
                TextButton(onClick = { /* Do something! */ }) {
                    Text("LOG IN", fontSize = 14.sp)
                }
            }
        }

    }
