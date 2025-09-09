package com.mohammed_hazem.smart_software.x_clone.user_feature.database.repo

import com.mohammed_hazem.smart_software.x_clone.user_feature.database.model.Follow
import org.bson.types.ObjectId
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository

interface FollowRepo : MongoRepository<Follow, ObjectId> {
    fun findAllByFollowerOrderBySinceDesc(follower : ObjectId, pageable: Pageable) : Page<Follow>
    fun findAllByFollowedOrderBySinceDesc(followed : ObjectId, pageable: Pageable) : Page<Follow>

    fun existsByFollowerAndFollowed(follower: ObjectId, followed: ObjectId)
}