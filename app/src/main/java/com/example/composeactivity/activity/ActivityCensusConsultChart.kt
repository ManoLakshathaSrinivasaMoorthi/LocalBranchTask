package com.example.composeactivity.activity

import android.graphics.Color.rgb
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class ActivityCensusConsultChart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme() {
                TopToolBar()
            }
        }
    }
    @Composable
    private fun TopToolBar() {

        Column() {

            TitleBar()
            Spacer(modifier = Modifier.requiredSize(10.dp))
            CardViews()
        }


    }

    @Composable
    fun TitleBar() {
        Column {
            TopAppBar(elevation = 4.dp,
                title = {
                    Text("eConsult Chart")
                },
                backgroundColor = Color.Blue,
                navigationIcon = {
                    IconButton(onClick = {/* Do Something*/ }) {
                        Icon(Icons.Filled.ArrowBack, null)
                    }
                }, actions = {
                    IconButton(onClick = {/* Do Something*/ }) {
                        Icon(Icons.Filled.Share, null)
                    }
                    /*  IconButton(onClick = { showDialog.value = true }) {
                          Icon(Icons.Filled.Settings, null)
                      }*/
                })



        }
    }

    @Composable
    fun CardViews() {
        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor = MaterialTheme.colors.surface,
        ) {
            Column(
                modifier = Modifier
                    .height(80.dp)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(text = "This is a card view",
                    style = MaterialTheme.typography.h4)
            }
        }
    }
}