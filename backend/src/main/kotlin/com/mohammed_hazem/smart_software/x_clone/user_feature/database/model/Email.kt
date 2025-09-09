package com.mohammed_hazem.smart_software.x_clone.user_feature.database.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document
data class Email(
    @Id val email: String,
    @Indexed(expireAfter = "15m") val createdAt: Instant,
    val otp: String,
    val sessionId : String,
    val verified : Boolean = false
)