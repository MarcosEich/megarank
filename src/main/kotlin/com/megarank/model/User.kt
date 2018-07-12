package com.megarank.model

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import org.springframework.data.mongodb.core.mapping.Document

@TypeAlias("User")
@Document(collection = "User")
data class User(
        @Id val id: String,
        val name: String,
        val email: String
)