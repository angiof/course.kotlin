package com.course.course.kotlin.test

import com.course.course.kotlin.controler.GretingControler
import com.course.course.kotlin.injections.GreetingsServices
import io.mockk.every
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.reactive.server.WebTestClient

@WebMvcTest(controllers = [GretingControler::class])
@AutoConfigureWebTestClient
class GreetngsControllerTestInt {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @MockBean
    lateinit var gretingsServicesMock: GreetingsServices


    @Test
    fun retriveGreetings() {

        val nome = "angelo"

         every { gretingsServicesMock.retriveSaluti(any()) } returns "$nome,Hello from default profile"

        val result = webTestClient.get()
            .uri("/v1/greetings/{name}",nome)
            .exchange()
            .expectStatus().is2xxSuccessful
            .expectBody(String::class.java)
            .returnResult()


        Assertions.assertEquals("$nome,Hello from default profile", result.responseBody)
    }

}