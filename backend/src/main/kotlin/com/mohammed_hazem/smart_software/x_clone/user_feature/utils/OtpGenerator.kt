package com.mohammed_hazem.smart_software.x_clone.user_feature.utils

import java.security.SecureRandom

object OtpGenerator {
    private val random = SecureRandom()

    fun generateNumericOtp(length: Int = 6): String {
        val otp = StringBuilder()
        repeat(length) {
            otp.append(random.nextInt(10)) // من 0 لحد 9
        }
        return otp.toString()
    }
}