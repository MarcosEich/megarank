package com.megarank.model

import org.springframework.data.annotation.Id

class Match(
        @Id val id: String,
        val player1: String,
        val player2: String,
        val score1: Int,
        val score2: Int
)