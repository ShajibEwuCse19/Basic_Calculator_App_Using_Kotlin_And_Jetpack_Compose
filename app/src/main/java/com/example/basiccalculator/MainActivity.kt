package com.example.basiccalculator

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basiccalculator.ui.theme.BasicCalculatorTheme

class MainActivity : ComponentActivity() {
    private val textValue1 = mutableStateOf("")
    private val textValue2 = mutableStateOf("")
    private val resultValue = mutableStateOf("Result")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val context = LocalContext.current
                    Column(modifier = Modifier) {
                        TextField(
                            value = textValue1.value,
                            onValueChange = {
                                textValue1.value = it
                            },
                            label = {
                                Text(text = "Enter Your First Number")
                            },
                            placeholder = {
                                Text(text = "This is a number field.")
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            )
                        )
                        Spacer(modifier = Modifier.padding(20.dp))
                        TextField(
                            value = textValue2.value,
                            onValueChange = {
                                textValue2.value = it
                            },
                            label = {
                                Text(text = "Enter your second number")
                            },
                            placeholder = {
                                Text(text = "This is a number field.")
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            )
                        )

                        Spacer(modifier = Modifier.padding(20.dp))

                        Button(onClick = {
                            //Log.d("Button", "clicked")
                            if(textValue1.value.isNotEmpty() && textValue2.value.isNotEmpty()) {
                                try {
                                    val multiplyByTwo = textValue1.value.toInt() + textValue2.value.toInt()
                                    resultValue.value = "Your Result = $multiplyByTwo"
                                } catch (e: Exception) {
                                    Toast.makeText(context, "Invalid Input", Toast.LENGTH_SHORT).show()
                                }
                            } else Toast.makeText(context, "Invalid Input", Toast.LENGTH_SHORT).show()
                        }) {{ /*TODO*/ }
                            Text(text = "Plus")
                        }
                        Spacer(modifier = Modifier.padding(10.dp))
                        Button(onClick = {
                            if (textValue1.value.isNotEmpty() && textValue2.value.isNotEmpty()) {
                                try {
                                    resultValue.value = "Your Result = " + (textValue1.value.toInt() - textValue2.value.toInt())
                                }catch (e: Exception) {
                                    Toast.makeText(context, "Invalid Input", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }) {
                            Text(text = "Minus")
                        }
                        Spacer(modifier = Modifier.padding(10.dp))
                        Button(onClick = {
                            if (textValue1.value.isNotEmpty() && textValue2.value.isNotEmpty()) {
                                try {
                                    resultValue.value = "Your Result = " + (textValue1.value.toInt() * textValue2.value.toInt())
                                }catch (e: Exception) {
                                    Toast.makeText(context, "Invalid Input", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }) {
                            Text(text = "Multiplication")
                        }
                        Spacer(modifier = Modifier.padding(10.dp))
                        Button(onClick = {
                            if (textValue1.value.isNotEmpty() && textValue2.value.isNotEmpty()) {
                                try {
                                    resultValue.value = "Your Result = " + (textValue1.value.toInt() / textValue2.value.toInt())
                                }catch (e: Exception) {
                                    Toast.makeText(context, "Invalid Input", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }) {
                            Text(text = "Division")
                        }
                        Spacer(modifier = Modifier.padding(20.dp))
                        Text(resultValue.value)
                    }
                }
            }
        }
    }
}