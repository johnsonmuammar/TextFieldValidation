package com.example.textboxvalidationcomponent.domain.use_case.validate_text

import android.util.Log
import com.example.textboxvalidationcomponent.domain.model.ValidationItem

class ValidateTextUseCase( errorExpressionList:List<Regex> = listOf(Regex("[^A-Za-z0-9 ]")),
                           infoExpressionList: List<Regex> = listOf(Regex("[^ ]")))
{
    val errorExpressionList = errorExpressionList
    val infoExpressionList = infoExpressionList

    val TAG = "validated"
    fun validateTextError(inputString: String): ValidationItem {
        lateinit var errorValidationItem: ValidationItem
        for(re in this.errorExpressionList) {
            if (re.containsMatchIn(inputString)) {
                Log.d(TAG, "validated found")
                errorValidationItem= ValidationItem(true, "something wrong")
            } else {
                Log.d(TAG, "validated not found all good")
                errorValidationItem= ValidationItem(false, "all good")
            }
        }
        return errorValidationItem
    }

    fun validationInfo(inputString: String): ValidationItem {
        lateinit var infoValidationItem: ValidationItem
        for(re in this.infoExpressionList) {
            if (re.containsMatchIn(inputString)) {
                Log.d(TAG, "validated found")
                infoValidationItem= ValidationItem(true, "keStrokes")
            } else {
                Log.d(TAG, "validated not found all good")
                infoValidationItem= ValidationItem(false, "all good")
            }
        }
        return infoValidationItem
    }

}