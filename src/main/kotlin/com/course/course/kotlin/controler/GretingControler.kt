package com.course.course.kotlin.controler

import com.course.course.kotlin.injections.GreetingsServices
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/gree")
class GretingControler(val greetingsServices: GreetingsServices) {

    @GetMapping("/{name}")
    fun greetings(@PathVariable("name") name: String): String = greetingsServices.retriveSaluti(name)

    @GetMapping("/p")
    fun getP() :String {

        for ( i in 1..5){
            val p =i
            return  " $p"
        }

        return "non è vero"
    }



}