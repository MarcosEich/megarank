package com.megarank.model

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import org.springframework.data.mongodb.core.mapping.Document

@TypeAlias("Match")
@Document(collection = "Match")
class Match(
        @Id var id: String = "",
        val player1: String,
        val player2: String,
        val score1: Int,
        val score2: Int,
        val ranking: String
)