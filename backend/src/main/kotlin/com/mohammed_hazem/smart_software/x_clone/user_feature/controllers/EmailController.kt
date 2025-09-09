package com.mohammed_hazem.smart_software.x_clone.user_feature.controllers

import com.mohammed_hazem.smart_software.x_clone.user_feature.database.repo.EmailRepo
import com.mohammed_hazem.smart_software.x_clone.user_feature.database.repo.UserRepo
import com.mohammed_hazem.smart_software.x_clone.user_feature.service.UserService
import com.mohammed_hazem.smart_software.x_clone.utils.HttpStatusCodes
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServletResponse
import jakarta.validation.Valid
import jakarta.validation.constraints.Pattern
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/email")
class EmailController(
    private val userService: UserService
) {
    @PostMapping("/register")
    fun registerEmail(
        @Valid @RequestBody body: RegisterEmail,
        responseSevlet: HttpServletResponse
    ): ResponseEntity<String> {
        val emailEntry = userService.generateSession(body.email)
        val cookie = Cookie("sessionId", emailEntry.sessionId).apply {
            isHttpOnly = true
            path = "/"
            maxAge = 15 * 60
        }
        responseSevlet.addCookie(cookie)
        return ResponseEntity.ok("Mail Sent Successfully")
    }

    @PostMapping("/verify")
    fun verify(@RequestBody body: Verify, @CookieValue("sessionId") sessionId: String): ResponseEntity<String> {
        val success = userService.verify(sessionId, body.email, body.otp)
        return if (success)
            ResponseEntity.ok("Verified Successfully")
        else
            ResponseEntity.badRequest().body("Not Verified. Something Went Wrong")
    }

    data class RegisterEmail(
        @field:Pattern(
            regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
            message = "That is not valid email"
        ) val email: String
    )

    data class Verify(
        val email: String,
        val otp: String
    )
}