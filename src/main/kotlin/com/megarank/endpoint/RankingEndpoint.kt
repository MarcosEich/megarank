package com.megarank.endpoint

import com.megarank.dto.UserPosition
import com.megarank.service.PositionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rankings")
class RankingEndpoint {
    @Autowired
    lateinit var positionService: PositionService

    @GetMapping("{id}/positions")
    fun ranking(@PathVariable id: String): List<UserPosition> {
        return positionService.positions()
    }
}