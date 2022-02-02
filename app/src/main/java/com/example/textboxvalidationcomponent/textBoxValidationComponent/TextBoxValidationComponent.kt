package com.example.textboxvalidationcomponent.textBoxValidationComponent

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.textboxvalidationcomponent.domain.model.Type
import com.example.textboxvalidationcomponent.domain.model.ValidationObject
import com.example.textboxvalidationcomponent.domain.use_case.validate_text.ValidateTextUseCase


val TAG = "Validated Text Field"
@Composable
fun ValidatedTextField(field_label:String ="",
                       errorValidationList:List<ValidationObject>

) {
    var validateTextUseCase = ValidateTextUseCase(errorValidationList)
    var text by remember { mutableStateOf("") }
    var infoText by remember { mutableStateOf("") }
    var color by remember { mutableStateOf(Color.Black) }
    var infoTextFlag by remember { mutableStateOf(false) }

    fun validate(inputSting: String) {
        text = inputSting
        val validationObject = validateTextUseCase.validateText(inputString = inputSting)
        if (validationObject != null) {

            color = if (validationObject.type == Type.ERROR) Color.Red else Color.DarkGray
            infoText = validationObject.message
            infoTextFlag = true
        } else {
            infoText = ""
            infoTextFlag = false
        }


    }
    Column(modifier = Modifier.padding(10.dp).semantics(mergeDescendants = true) {}) {
        TextField(
            value = text,
            onValueChange = { newText ->
                validate(newText)
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = { validate((text)) }
            ),
            label = { Text(field_label) },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent
            ),
            trailingIcon = {
                if (infoTextFlag && color == Color.Red) {
                    Icon(Icons.Filled.Info, "error", tint = Color.Red)
                } else if (infoTextFlag && color == Color.DarkGray) {
                    Icon(Icons.Filled.Info, "error", tint = Color.DarkGray)
                }
            },
            isError = infoTextFlag && color == Color.Red

        )
        Text(
            text = if (infoTextFlag) infoText else "",
            color = color
        )
    }
}

