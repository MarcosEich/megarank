package com.megarank.model

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import org.springframework.data.mongodb.core.mapping.Document

@TypeAlias("Position")
@Document(collection = "Position")
class Position(
        @Id val id: String,
        val ranking: String,
        var position: Int,
        val user: String
)