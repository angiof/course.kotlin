package com.course.course.kotlin.injections

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class GreetingsServices {


    @Value("\${message}")
    lateinit var name2: String

    //fun che permette il servizio di dipendences
    fun retriveSaluti(name: String) = "ciao sir $name $name2,"


}