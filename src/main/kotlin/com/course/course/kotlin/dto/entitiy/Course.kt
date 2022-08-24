package com.course.course.kotlin.dto.entitiy

import javax.persistence.*

@Entity
@Table(name = "courses")
data class Course(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Int? = null,
    val name: String?,
    val category: String?
)