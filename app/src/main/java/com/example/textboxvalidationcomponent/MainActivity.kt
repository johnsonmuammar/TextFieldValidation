package com.example.textboxvalidationcomponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.textboxvalidationcomponent.textBoxValidationComponent.ValidatedNameField
import com.example.textboxvalidationcomponent.ui.theme.TextBoxValidationComponentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextBoxValidationComponentTheme {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var errorText by remember {
                        mutableStateOf("Something went wrong")
                    }
                    var errorFlag by remember {
                        mutableStateOf(false)
                    }
                    Column() {
                        Row(
                            horizontalArrangement = Arrangement.SpaceAround,
                            modifier = Modifier.fillMaxWidth()

                        ) {
                            ValidatedNameField(
                                field_label = "First Name",
                                 )
                            ValidatedNameField(field_label = "Last Name",
                                )
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TextBoxValidationComponentTheme {
        Greeting("Android")
    }
}