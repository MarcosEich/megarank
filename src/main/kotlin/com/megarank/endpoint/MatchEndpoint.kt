package com.megarank.endpoint

import com.megarank.model.Match
import com.megarank.service.MatchService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("matches")
class MatchEndpoint {
    @Autowired
    lateinit var service: MatchService

    @PostMapping()
    fun match(@RequestBody match: Match): Match {
        return service.create(match)
    }
}