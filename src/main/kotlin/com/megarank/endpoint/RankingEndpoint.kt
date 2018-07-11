package com.megarank.endpoint

import com.megarank.model.Position
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("positions")
class RankingEndpoint {

    @GetMapping()
    fun blog(model: Model): List<Position> {
        return listOf(Position("1", "Marcos"))
    }
}