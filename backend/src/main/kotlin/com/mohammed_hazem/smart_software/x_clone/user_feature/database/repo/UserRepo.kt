package com.mohammed_hazem.smart_software.x_clone.user_feature.database.repo

import com.mohammed_hazem.smart_software.x_clone.user_feature.database.model.User
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepo : MongoRepository<User, ObjectId> {
    fun existsByEmail(email: String): Boolean
}