package com.course.course.kotlin.controler

import com.course.course.kotlin.injections.GreetingsServices
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/greetings")
class GretingControler(val greetingsServices: GreetingsServices) {

    @GetMapping("/{name}")
    fun greetings(@PathVariable("name") name: String): String = greetingsServices.retriveSaluti(name)
}