package com.megarank.util

import com.megarank.model.Match

fun winner(match: Match): String {
    if(match.score1 > match.score2) {
        return match.player1
    }
    return match.player2
}
