package com.megarank.service

import com.megarank.model.Match
import com.megarank.repository.MatchRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("MatchService")
class MatchService {

    @Autowired
    lateinit var repository: MatchRepository

    @Autowired
    lateinit var positionService: PositionService

    fun matches(): List<Match> = repository.findAll()

    fun create(match: Match): Match {
        positionService.update(match)
        return repository.save(match)
    }
}