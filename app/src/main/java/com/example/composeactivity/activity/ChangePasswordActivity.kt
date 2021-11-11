package com.example.composeactivity.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeactivity.R

class ChangePasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppScreen()
        }
    }
    @Composable
    private fun AppScreen() {
        Column(Modifier.padding(10.dp),Arrangement.Top) {
            Backbutton()
            Spacer(modifier = Modifier.height(1.dp))
            Logobutton()
            Spacer(modifier = Modifier.height(1.dp))
            Contentsspace()
        }


    }

    private @Composable
    fun Backbutton() {
        Column(modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.Top) {
            IconButton(onClick = { /*TODO*/ }) {
                Image(painterResource(id = R.drawable.ic_back_arrow),contentDescription = "")
            }
        }
    }

    @Composable
    fun Logobutton() {
        Column(modifier = Modifier.padding(30.dp), verticalArrangement = Arrangement.Top) {
            Image(painterResource(id = R.drawable.ic_logo),contentDescription = "",Modifier.requiredSize(50.dp,50.dp))
        }
    }
     @Composable
    fun Contentsspace() {
       val new_Password=remember{ mutableStateOf("")}
       val confirm_Password=remember{ mutableStateOf("")}

       Column(modifier = Modifier
           .padding(20.dp),verticalArrangement = Arrangement.Top,horizontalAlignment = Alignment.Start) {
           Text(text = "New Password",fontSize = 30.sp,modifier = Modifier.height(50.dp))
       }
         Spacer(modifier = Modifier.requiredSize(2.dp))
         Text(text = "Enter your new password below.",fontSize = 14.sp)
         Spacer(modifier = Modifier.requiredSize(2.dp))
         Column(modifier = Modifier.padding(10.dp),verticalArrangement = Arrangement.Center,
         horizontalAlignment = Alignment.Start) {
             OutlinedTextField(value = new_Password.value,
                 onValueChange = { new_Password.value = it },
                 placeholder = { Text(text = "Enter new password") }, singleLine = true,
                 modifier = Modifier.fillMaxWidth(1f),
                 trailingIcon = {
                     Image(
                         painter = painterResource(id = R.drawable.ic_visibility),
                         contentDescription = ""
                     )
                 })
             Spacer(modifier = Modifier.requiredSize(20.dp))
             OutlinedTextField(value = confirm_Password.value,
                 onValueChange = { confirm_Password.value = it },
                 placeholder = { Text(text = "Confirm new password") }, singleLine = true,
                 modifier = Modifier.fillMaxWidth(1f),
                 trailingIcon = {
                     Image(painter = painterResource(id = R.drawable.ic_visibility), contentDescription = ""
                     ) })
             Spacer(modifier = Modifier.requiredSize(25.dp))
              Button(onClick = { /*TODO*/ },Modifier.fillMaxWidth(1f)) {
                  Text(text = "Save new password")
              }
             
         }

    }
}