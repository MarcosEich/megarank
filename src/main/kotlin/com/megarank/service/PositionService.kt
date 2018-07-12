package com.megarank.service

import com.megarank.model.Position
import com.megarank.repository.PositionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("positionService")
class PositionService {

    @Autowired
    lateinit var positionRepository: PositionRepository

    fun positions(): List<Position> = positionRepository.findAll()
}