package com.example.textboxvalidationcomponent.textBoxValidationComponent

import android.util.Log
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.textboxvalidationcomponent.domain.use_case.validate_text.ValidateTextUseCase


val TAG = "Validated Text Field"
@Composable
fun ValidatedNameField(field_label:String ="", flagFuction: (Boolean)->Unit){
    var text by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = text,
        onValueChange ={ newText -> text = newText
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next ),
        keyboardActions = KeyboardActions(onNext = {flagFuction(ValidateTextUseCase.validateName(text))}),
        label = {Text(field_label)},
        modifier = Modifier.width(160.dp)
        )
}

@Composable
fun ValidatedEmailField(){
    var text by remember {
        mutableStateOf("")
    }
    TextField(
        value = text,
        onValueChange ={ newText -> text = newText
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next ),
        keyboardActions = KeyboardActions(onNext = {ValidateTextUseCase.validateName(text)})
    )
}

@Composable
fun ValidatedPhoneField(){
    var text by remember {
        mutableStateOf("")
    }
    TextField(
        value = text,
        onValueChange ={ newText -> text = newText
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next ),
        keyboardActions = KeyboardActions(onNext = {ValidateTextUseCase.validateName(text)})
    )
}