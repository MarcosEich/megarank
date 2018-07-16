package com.megarank.repository

import com.megarank.model.Position
import org.springframework.data.mongodb.repository.MongoRepository

interface PositionRepository: MongoRepository<Position, String> {

    fun getByUser(user: String): Position
}