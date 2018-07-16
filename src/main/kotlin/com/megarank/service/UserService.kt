package com.megarank.service

import com.megarank.model.User
import com.megarank.repository.PositionRepository
import com.megarank.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("UserService")
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    fun user(id: String): User {
        return userRepository.findById(id).get()
    }

}