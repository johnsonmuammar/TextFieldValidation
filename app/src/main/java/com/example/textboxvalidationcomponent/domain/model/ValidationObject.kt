package com.example.textboxvalidationcomponent.domain.model

 data class ValidationObject(
     val message: String,
     val type: Type,
     val pattern: Regex,
 )

