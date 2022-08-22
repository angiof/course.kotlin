package com.course.course.kotlin.injections

import org.springframework.stereotype.Service

@Service
class GreetingsServices {
    fun retriveSaluti(name: String) = "ciao sir $name"
}