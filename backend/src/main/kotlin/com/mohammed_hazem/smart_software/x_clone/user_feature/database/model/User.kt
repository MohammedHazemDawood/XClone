package com.mohammed_hazem.smart_software.x_clone.user_feature.database.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDate

@Document
data class User(
    @Indexed(unique = true) val email: String,
    @Indexed(unique = true) val name: String,
    @Field("display_name") val displayName: String,
    @Indexed(unique = true) @Field("phone_number") val phoneNumber: String,
    val bio: String,
    val website: String,
    val gender: String,
    val location: String,
    @Field("date_of_birth") val dateOfBirth: LocalDate,

    @Id val id: ObjectId = ObjectId.get(),
    val hashedPassword: String,
    @Field("created_at") val createdAt: String,
    val private: Boolean,
    val active: Boolean,
)