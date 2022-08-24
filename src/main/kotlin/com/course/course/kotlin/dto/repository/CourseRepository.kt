package com.course.course.kotlin.dto.repository

import com.course.course.kotlin.dto.entitiy.Course
import org.springframework.data.repository.CrudRepository

interface CourseRepository :CrudRepository<Course,Int> {
}