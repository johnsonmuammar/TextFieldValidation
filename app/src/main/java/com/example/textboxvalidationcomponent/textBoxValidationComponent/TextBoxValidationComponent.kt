package com.example.textboxvalidationcomponent.textBoxValidationComponent

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.textboxvalidationcomponent.domain.model.ValidationItem
import com.example.textboxvalidationcomponent.domain.use_case.validate_text.ValidateTextUseCase


val TAG = "Validated Text Field"
@Composable
fun ValidatedNameField(field_label:String ="",
                       errorExpressionList:List<Regex> = listOf(Regex("[^A-Za-z0-9 ]")),
                       infoExpressionList: List<Regex> = listOf(Regex("")),
                       ){
    var validateTextUseCase = ValidateTextUseCase(errorExpressionList,infoExpressionList)
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
    fun red(validationItem: ValidationItem){
        color = Color.Red
        infoText = validationItem.errorStatement
        infoTextFlag = validationItem.errorFlag

    }
    fun blue(currentText: String){
        color = Color.DarkGray
        text = currentText
        val validationInfo =validateTextUseCase.validationInfo(currentText)
        infoText = validationInfo.errorStatement
        infoTextFlag = validationInfo.errorFlag

    }
    Column() {
        OutlinedTextField(
            value = text,
            onValueChange = { newText ->
                blue(newText)
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = { red(validateTextUseCase.validateTextError(text)) }
            ),
            label = { Text(field_label) },
            modifier = Modifier.fillMaxWidth(),

        )
        if (infoTextFlag) {
            Text(text = infoText, color = color )
        }
    }
}
