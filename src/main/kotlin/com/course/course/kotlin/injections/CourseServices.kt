package com.course.course.kotlin.injections

import com.course.course.kotlin.dto.CourseDTO
import com.course.course.kotlin.dto.entitiy.Course
import com.course.course.kotlin.dto.repository.CourseRepository
import mu.KLogging
import org.springframework.stereotype.Service

@Service
class CourseServices(val courseRepository: CourseRepository) {
    companion object : KLogging()

    fun addCourse(courseDTO: CourseDTO) {

        val courseEntiti = courseDTO.let {
            Course(null, it.name, it.category)
        }
        courseRepository.save(courseEntiti)
        logger.info("save corse is $courseEntiti")
    }

    fun retriveAllCourses(): List<CourseDTO> {
      return  courseRepository.findAll()
            .map {
                CourseDTO(it.id,it.name,it.category)
            }
    }
}