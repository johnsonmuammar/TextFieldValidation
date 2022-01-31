package com.example.textboxvalidationcomponent.domain.use_case.validate_text

import android.util.Log
import com.example.textboxvalidationcomponent.domain.model.Type
import com.example.textboxvalidationcomponent.domain.model.ValidationObject

class ValidateTextUseCase( validationObjectList:List<ValidationObject> = listOf(ValidationObject("default message", Type.ERROR, Regex(""))))
{
    val validationObjectList = validationObjectList

    val TAG = "validated"
    fun validateText(inputString: String): ValidationObject? {

        for(currentValidationObject in this.validationObjectList) {
            if (!currentValidationObject.pattern.containsMatchIn(inputString)) {
                Log.d(TAG, "validated found")
                return  currentValidationObject
            }

        }
        return null
    }


}