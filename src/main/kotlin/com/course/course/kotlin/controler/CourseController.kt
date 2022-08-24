package com.course.course.kotlin.controler

import com.course.course.kotlin.dto.CourseDTO
import com.course.course.kotlin.injections.CourseServices
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/courses")
class CourseController(val courseServices: CourseServices) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addCourse(@RequestBody courseDTO: CourseDTO) = courseServices.addCourse(courseDTO)
}
