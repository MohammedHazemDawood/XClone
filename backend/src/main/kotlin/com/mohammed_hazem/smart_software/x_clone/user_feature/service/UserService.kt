package com.mohammed_hazem.smart_software.x_clone.user_feature.service

import com.mohammed_hazem.smart_software.x_clone.user_feature.database.model.Email
import com.mohammed_hazem.smart_software.x_clone.user_feature.database.repo.EmailRepo
import com.mohammed_hazem.smart_software.x_clone.user_feature.database.repo.UserRepo
import com.mohammed_hazem.smart_software.x_clone.user_feature.utils.HtmlTemplates
import com.mohammed_hazem.smart_software.x_clone.user_feature.utils.OtpGenerator
import com.mohammed_hazem.smart_software.x_clone.utils.HttpStatusCodes
import org.springframework.http.HttpStatusCode
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.time.Instant
import java.time.LocalDateTime
import java.util.*


@Service
class UserService(
    private val emailRepo: EmailRepo,
    private val sender: JavaMailSender,
    private val userRepo: UserRepo
) {

    fun generateSession(email: String): Email {
        if (userRepo.existsByEmail(email))
            throw ResponseStatusException(HttpStatusCodes.CONFLICT, "This Email is already used")
        val sessionId = UUID.randomUUID().toString()
        val otp = OtpGenerator.generateNumericOtp()

        return emailRepo.save(Email(email, Instant.now(), otp, sessionId)).also {
            sendVerificationMail(it)
        }
    }

    fun verify(sessionId: String, email: String, otp: String): Boolean {
        val emailEntiry = emailRepo.findById(email).orElseThrow {
            ResponseStatusException(HttpStatusCodes.NOT_FOUND, "This email is not in verifing mode, maybe it expired")
        }
        if (emailEntiry.verified)
            throw ResponseStatusException(HttpStatusCodes.BAD_REQUEST, "This email is already verified")
        if (otp != emailEntiry.otp || sessionId != emailEntiry.sessionId)
            return false
        emailRepo.save(emailEntiry.copy(verified = true))
        return true
    }

    private fun sendVerificationMail(email: Email) {
        val message = sender.createMimeMessage()
        val helper = MimeMessageHelper(message, "UTF-8")
        helper.setTo(email.email)
        helper.setSubject("Verify Your Mail To Continue")
        helper.setText(HtmlTemplates.verificationEmail(email.otp, email.createdAt))
        sender.send(message)
    }

}