package com.megarank.repository

import com.megarank.model.Position
import com.megarank.model.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository: MongoRepository<User, String>