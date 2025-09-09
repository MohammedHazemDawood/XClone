package com.mohammed_hazem.smart_software.x_clone.user_feature.database.repo

import com.mohammed_hazem.smart_software.x_clone.user_feature.database.model.Email
import org.springframework.data.mongodb.repository.MongoRepository

interface EmailRepo : MongoRepository<Email, String> {
    
}