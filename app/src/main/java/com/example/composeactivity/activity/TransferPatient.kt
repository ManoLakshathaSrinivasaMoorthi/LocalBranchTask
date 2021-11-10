package com.example.composeactivity.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Button
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeactivity.ui.theme.bg_blue

class TransferPatient : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            transferpatient()
        }
    }
    @Composable
    fun transferpatient() {
        AppTitleBar()
        Spacer(modifier = Modifier.height(10.dp))
        Column(modifier = Modifier.padding(25.dp)) {
            firstSection()
            Spacer(modifier = Modifier.height(10.dp))
            secondsection()
            Spacer(modifier = Modifier.height(10.dp))
            thirdsection()
            Spacer(modifier = Modifier.height(10.dp))
            fourthsection()
        }


            }
    @Composable
    private fun firstSection() {
        val radioOptions =
            listOf("Transfer within hospital/site", "Transfer to another hospital/site")
        val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1]) }
        Box(Modifier.padding(16.dp, 60.dp, 16.dp, 50.dp).size(600.dp, 100.dp).border(width = 4.dp, color = bg_blue)) {
            Column(
                modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Column {
                    radioOptions.forEach { text ->
                        Row(Modifier.fillMaxWidth()
                            .selectable(selected = (text == selectedOption),
                                onClick = { onOptionSelected(text) }
                            ).padding(horizontal = 16.dp)) {

                            //     val context = ContextAmbient.current

                            RadioButton(

                                selected = (text == selectedOption),
                                modifier = Modifier.padding(all = Dp(value = 8F)),
                                onClick = {

                                    onOptionSelected(text)

                                    //Toast.makeText(context, text, Toast.LENGTH_LONG).show()
                                }
                            )
                            // below line is use to add
                            // text to our radio buttons.
                            Text(
                                text = text,
                                modifier = Modifier.padding(start = 16.dp)
                            )
                        }
                    }

                }
            }
        }

    }
    @Composable
    private fun secondsection() {
        Box(Modifier.padding(16.dp, 60.dp, 16.dp, 5.dp).size(600.dp, 50.dp).border(width = 4.dp, color = bg_blue)) {
            Column {

            }
        }

    }
    @Composable
    private fun thirdsection() {
        Box(Modifier.padding(16.dp, 60.dp, 16.dp, 5.dp).size(600.dp, 50.dp).border(width = 4.dp, color = bg_blue)) {
            Column {

            }
        }

    }
    @Composable
    private fun fourthsection() {
        val transPatient = remember { mutableStateOf(TextFieldValue()) }
        Box(Modifier.padding(16.dp, 60.dp, 16.dp, 5.dp).size(600.dp, 120.dp)
            .border(width = 4.dp, color = bg_blue).background(Color.LightGray)) {
            Column {
                TextField(value = transPatient.value,
                    onValueChange = { transPatient.value = it },
                    placeholder = { Text(text = "Summary Note") })
            }
        }
        Spacer(modifier = Modifier.requiredSize(90.dp))
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Transfer Patient", color = Color.White, fontSize = 14.sp)
        }
    }


    private @Composable
    fun AppTitleBar() {

    }
}