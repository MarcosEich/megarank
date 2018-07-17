package com.megarank.service

import com.megarank.dto.UserPosition
import com.megarank.model.Match
import com.megarank.model.Position
import com.megarank.repository.PositionRepository
import com.megarank.util.winner
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("positionService")
class PositionService {

    @Autowired
    lateinit var positionRepository: PositionRepository

    @Autowired
    lateinit var userService: UserService

    fun positions(): List<UserPosition> {
        val positions = positionRepository.findAll()
        return positions.map {
            UserPosition(name = name(it.user), position = it.position)
        }
    }

    private fun name(userId: String): String {
        return userService.user(userId).name
    }

    fun update(match: Match) {
        val position1 = positionRepository.getByUser(match.player1)
        val position2 = positionRepository.getByUser(match.player2)

        val ranking = listOf(position1, position2)
                .sortedBy(Position::position)

        val bestInRank = 0
        val worstInRank = 1
        if(winner(match) == ranking[worstInRank].user) {
            updateRanking(ranking[worstInRank], ranking[bestInRank])
        }
    }

    private fun updateRanking(worstInRank: Position, bestInRank: Position) {
        val lowerRank = worstInRank.position
        worstInRank.position = bestInRank.position
        bestInRank.position++

        positionRepository.findAll()
                .forEach { update(it,  lowerRank, bestInRank.position) }

        positionRepository.saveAll(listOf(bestInRank, worstInRank))
    }

    private fun update(position: Position, lowerRank: Int, higherRank: Int) {
        if (position.position in higherRank..(lowerRank - 1)) {
            position.position++
            positionRepository.save(position)
        }
    }
}