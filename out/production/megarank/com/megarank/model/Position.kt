package com.megarank.model

import org.springframework.data.annotation.TypeAlias
import org.springframework.data.mongodb.core.mapping.Document

@TypeAlias("Position")
@Document(collection = "Position")
class Position(
        val position: Int,
        val user: String)