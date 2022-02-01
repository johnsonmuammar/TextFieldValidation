package com.example.textboxvalidationcomponent.textBoxValidationComponent

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import com.example.textboxvalidationcomponent.domain.model.Type
import com.example.textboxvalidationcomponent.domain.model.ValidationObject
import com.example.textboxvalidationcomponent.domain.use_case.validate_text.ValidateTextUseCase


val TAG = "Validated Text Field"
@Composable
fun ValidatedTextField(field_label:String ="",
                       errorValidationList:List<ValidationObject>

){
    var validateTextUseCase = ValidateTextUseCase(errorValidationList)
    var text by remember {
        mutableStateOf("")
    }
    var infoText  by remember{
        mutableStateOf("")}
    var color by remember {
     mutableStateOf(Color.Black)
    }

    var infoTextFlag by remember {
        mutableStateOf(false)
    }
    fun validate(inputSting: String){
        text = inputSting
        val validationObject = validateTextUseCase.validateText(inputString = inputSting)
         if (validationObject != null) {

             color =  if (validationObject.type == Type.ERROR) Color.Red else Color.DarkGray
             infoText = validationObject.message
             infoTextFlag = true
            }else{
                infoText = ""
                infoTextFlag = false
         }



    }
    Column() {
        OutlinedTextField(
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

        )
        if (infoTextFlag) {
            Text(text = infoText, color = color )
        }else{
            Text(text = "")
        }
    }
}

