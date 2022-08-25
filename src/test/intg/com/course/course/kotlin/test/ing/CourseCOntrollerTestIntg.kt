package com.course.course.kotlin.test.ing

import com.course.course.kotlin.dto.CourseDTO
import mu.KLogging
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureWebClient
class CourseCOntrollerTestIntg {

    companion object : KLogging()

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    fun testAdCourse() {
        val courseDto = CourseDTO(null, "Build Restfull APIs using SprintBoot and Kotlin", "angelo ferretti")

        val saveCourseDTO = webTestClient.post()
            .uri("/courses")
            .bodyValue(courseDto)
            .exchange()
            .expectStatus().isCreated
            .expectBody(CourseDTO::class.java)
            .returnResult()
            .responseBody
        Assertions.assertTrue {
            saveCourseDTO!!.id != null
        }
    }

}