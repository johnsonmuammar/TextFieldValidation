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
import com.example.textboxvalidationcomponent.domain.model.Type
import com.example.textboxvalidationcomponent.domain.model.ValidationObject
import com.example.textboxvalidationcomponent.textBoxValidationComponent.ValidatedTextField
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

                    Column() {

                            ValidatedTextField(
                                field_label = "First Name",
                                listOf(
                                    ValidationObject("UserName Empty", Type.HINT,
                                    Regex("^.+\$"))
                                )
                                )

                        ValidatedTextField(
                            field_label = "Other Name",
                            listOf(ValidationObject("UserName Empty", Type.HINT,
                                Regex("^.+\$")), ValidationObject("UserName Syntax", Type.ERROR,
                                Regex("^[a-zA-Z0-9@_.,-]*\$")
                            )
                            )
                        )
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