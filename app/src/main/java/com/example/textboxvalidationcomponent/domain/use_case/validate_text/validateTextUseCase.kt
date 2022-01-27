package com.example.textboxvalidationcomponent.domain.use_case.validate_text

import android.util.Log

class ValidateTextUseCase {

    companion object{
        val TAG = "validated"
        fun validateName(name: String):Boolean{
            val re = Regex("[^A-Za-z0-9 ]")
            if(re.containsMatchIn(name)){
                Log.d(TAG, "validated found")
                return true
            }else{
                Log.d(TAG, "validated not found all good")
                return false
            }
        }

        fun validateEmail(name: String):Pair<Boolean, String>{
            val re = Regex("[^A-Za-z0-9@ ]")
            if(re.containsMatchIn(name)){
                Log.d(TAG, "validated found")
                return Pair(false, name)
            }else{
                Log.d(TAG, "validated not found all good")
                return Pair(true, name)
            }
        }
        fun validatePhone(name: String):Pair<Boolean, String>{
            val re = Regex("[^0-9]")
            if(re.containsMatchIn(name)){
                Log.d(TAG, "validated found")
                return Pair(false, name)
            }else{
                Log.d(TAG, "validated not found all good")
                return Pair(true, name)
            }
        }
    }
}