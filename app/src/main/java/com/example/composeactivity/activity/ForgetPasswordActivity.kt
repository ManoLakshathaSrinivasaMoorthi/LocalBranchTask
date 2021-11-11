package com.example.composeactivity.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeactivity.R

class ForgetPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            AppFields()
        }
    }
    @Composable
   fun AppFields() {
        Column(Modifier.padding(10.dp,10.dp)) {
            Image(painter = painterResource(id = R.drawable.ic_back_arrow), contentDescription = "") }
        Spacer(modifier = Modifier.height(3.dp))

        Column(Modifier.padding(30.dp)) {
            Image(painter = painterResource(id = R.drawable.ic_logo), contentDescription = "",
                Modifier.size(50.dp, 50.dp))
        }
        val emailandPhone= remember { mutableStateOf("") }
        Column(Modifier.padding(20.dp)) {
            Text(text = "Reset Password", fontSize = 30.sp)
        }
        Column(Modifier.padding(20.dp)){
            Text(text = "To reset your password enter the email address or phone number associated with your account."
                ,fontSize = 14.sp)

        }
        Spacer(modifier = Modifier.height(50.dp))
        Column {
            TextField(value = emailandPhone.value, onValueChange ={emailandPhone.value=it})
        }
    }
    @Composable
    private fun Tittles() {

    }
    @Composable
    private fun ContentOnly() {

    }
}