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

        val highRank = higher(position1, position2)
        val lowRank = lower(position1, position2)

        if(winner(match) == lowRank.user) {
            updateRanking(lowRank, highRank)
        }
    }

    private fun updateRanking(lowRank: Position, highRank: Position) {
        val lowerRank = lowRank.position
        lowRank.position = highRank.position
        highRank.position++

        positionRepository.findAll()
                .forEach { update(it,  lowerRank, highRank.position) }

        positionRepository.save(highRank)
        positionRepository.save(lowRank)
    }

    private fun update(position: Position, lowerRank: Int, higherRank: Int) {
        if (position.position in higherRank..(lowerRank - 1)) {
            position.position++
            positionRepository.save(position)
        }
    }

    private fun higher(pos1: Position, pos2: Position): Position {
        if(pos1.position < pos2.position) {
            return pos1
        }
        return  pos2
    }

    private fun lower(pos1: Position, pos2: Position): Position {
        if(pos1.position > pos2.position) {
            return pos1
        }
        return  pos2
    }
}