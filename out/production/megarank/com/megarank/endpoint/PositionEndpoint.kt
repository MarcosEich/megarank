package com.megarank.endpoint

import com.megarank.model.Position
import com.megarank.service.PositionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("positions")
class PositionEndpoint {

    @Autowired
    lateinit var positionService: PositionService

    @GetMapping()
    fun positions(): List<Position> {
        return positionService.positions()
    }
}