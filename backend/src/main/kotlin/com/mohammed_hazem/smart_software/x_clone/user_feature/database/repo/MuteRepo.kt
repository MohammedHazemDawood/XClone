package com.mohammed_hazem.smart_software.x_clone.user_feature.database.repo

import com.mohammed_hazem.smart_software.x_clone.user_feature.database.model.Mute
import org.bson.types.ObjectId
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository

interface MuteRepo : MongoRepository<Mute, ObjectId> {
    fun findAllByMuterOrderBySinceDesc(blocker: ObjectId, pageable: Pageable): Page<Mute>
    fun existsByMuterAndMuted(muter: ObjectId, muted: ObjectId)
}