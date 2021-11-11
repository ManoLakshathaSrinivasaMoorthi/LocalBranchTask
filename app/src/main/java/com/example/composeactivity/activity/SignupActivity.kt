package com.example.composeactivity.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeactivity.R
import com.example.composeactivity.ui.theme.LoginScreenTheme
import com.example.composeactivity.ui.theme.bg_blue
import com.example.composeactivity.ui.theme.color_ash

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Set Theme for Screen
            LoginScreenTheme {
                Box(
                    Modifier
                        .background(color = color_ash)
                        .fillMaxSize()) {
                    AppScreen()
                }

            }
        }
    }

    @Composable

    private fun AppScreen() {
        Column(modifier = Modifier.padding(20.dp)) {
            TitleFields()
            Spacer(modifier = Modifier.height(1.dp))
            HeaderText()
            Spacer(modifier = Modifier.height(20.dp))
            CenterText()
        }
    }

    @Composable
    private fun TitleFields() {
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

    }

    @Composable
    private fun HeaderText() {
        Column(modifier=Modifier.padding(10.dp,20.dp,2.dp,4.dp)) {

            Text(text = "Select your Account", fontSize = 18.sp, color = Color.LightGray)
        }

    }

    @Composable
    private fun CenterText() {
      Box(
          Modifier
              .background(color = Color.White)
              .border(width = 4.dp, color = bg_blue)){
          Column(Modifier.padding(10.dp)) {
              Text(
                  text = "Remote Provider,",
                  fontWeight = FontWeight.Bold,
                  fontSize = 16.sp
              )
              Spacer(modifier = Modifier.requiredSize(2.dp))
              Text(
                  text = "I am a critical care professional providing remote support",
                  fontSize = 14.sp
              )
          }
      }
        Spacer(modifier = Modifier.requiredSize(30.dp))
        LcpProvider()
    }
   @Composable
    private fun LcpProvider() {
        Box(Modifier
                .background(color = Color.White)
                .border(width = 4.dp, color = bg_blue)){
            Row(Modifier.padding(3.dp,2.dp,5.dp,2.dp),horizontalArrangement = Arrangement.Start) {
               Column(Modifier.padding(1.dp)) {
                   Text(
                       text = "Local Care Provider,",
                       fontWeight = FontWeight.Bold,
                       fontSize = 16.sp
                   )
                   Spacer(modifier = Modifier.requiredSize(2.dp))
                   Text(
                       text = "I am a healthcare professional \n taking care of patients onsite",
                       fontSize = 14.sp
                   )
               }
                Image(
                    painterResource(id = R.drawable.ic_logo),
                    contentDescription = "Login Image", modifier = Modifier.requiredSize(50.dp, 60.dp)
                )

            }

        }
       Spacer(modifier = Modifier.requiredSize(25.dp))
       Row(modifier=Modifier.padding(30.dp),verticalAlignment = Alignment.CenterVertically) {
           Text(text = "Already have account?", fontSize = 14.sp)
           TextButton(onClick = { /* Do something! */ }) {
               Text("LOG IN", fontSize = 14.sp)
           }
       }
    }
}