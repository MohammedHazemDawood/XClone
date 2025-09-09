package com.mohammed_hazem.smart_software.x_clone.user_feature.database.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document
data class Mute(
    @Id val id: ObjectId = ObjectId.get(),
    @Indexed val muter: ObjectId,
    @Indexed val muted: ObjectId,
    val since: Instant
)