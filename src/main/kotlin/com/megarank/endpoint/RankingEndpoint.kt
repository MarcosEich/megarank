package com.megarank.endpoint

import com.megarank.model.Position
import com.megarank.service.PositionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController("ranking/{id}")
class RankingEndpoint {
    @Autowired
    lateinit var positionService: PositionService

    @GetMapping("positions")
    fun ranking(@PathVariable id: String): List<Position> {
        return positionService.positions()
    }
}