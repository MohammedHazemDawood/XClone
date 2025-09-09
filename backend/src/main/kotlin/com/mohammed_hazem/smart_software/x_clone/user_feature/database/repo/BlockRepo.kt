package com.mohammed_hazem.smart_software.x_clone.user_feature.database.repo

import com.mohammed_hazem.smart_software.x_clone.user_feature.database.model.Block
import org.bson.types.ObjectId
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository

interface BlockRepo : MongoRepository<Block, ObjectId> {
    fun findAllByBlockerOrderBySinceDesc(blocker: ObjectId, pageable: Pageable): Page<Block>
    fun existsByBlockerAndBlocked(blocker: ObjectId, blocked: ObjectId)
}