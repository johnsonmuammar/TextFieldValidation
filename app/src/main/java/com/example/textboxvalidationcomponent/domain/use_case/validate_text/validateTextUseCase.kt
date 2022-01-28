package com.example.textboxvalidationcomponent.domain.use_case.validate_text

import android.util.Log
import com.example.textboxvalidationcomponent.domain.model.ValidationItem

class ValidateTextUseCase {

    companion object {
        val TAG = "validated"
        fun validateTextError(inputString: String): ValidationItem {
            val re = Regex("[^A-Za-z0-9 ]")
            if (re.containsMatchIn(inputString)) {
                Log.d(TAG, "validated found")
                return ValidationItem(true, "something wrong")
            } else {
                Log.d(TAG, "validated not found all good")
                return ValidationItem(false, "all good")
            }
        }

        fun validationInfo(inputString: String): ValidationItem {
            return ValidationItem(true, "keystrokes")

        }
    }
}