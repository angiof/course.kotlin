package com.course.course.kotlin.dto.repository

import com.course.course.kotlin.dto.entitiy.Course
import org.springframework.data.repository.CrudRepository

interface CourseRepo :CrudRepository<Course,Int> {
}