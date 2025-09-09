package com.mohammed_hazem.smart_software.x_clone.user_feature.utils

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

object HtmlTemplates {
    fun verificationEmail(otp: String, createdAt: Instant): String {
        // Ensure OTP is exactly 6 digits, pad with zeros if needed
        val formattedOTP = otp.padStart(6, '0').take(6)

        // Format creation time for display
        val formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy 'at' HH:mm")
        val createdAtFormatted = createdAt.atZone(ZoneId.systemDefault()).format(formatter)

        return """
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your X verification code</title>
</head>
<body style="margin: 0; padding: 0; box-sizing: border-box; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif; background: #000000; min-height: 100vh; width:fit-content; display: flex; align-items: center; justify-content: center; padding: 20px; position: relative; overflow: hidden;">
    <center>
    <div style="max-width: 600px; width: 100%; background: #000000; border: 1px solid #2f3336; border-radius: 16px; box-shadow: 0 4px 12px rgba(255, 255, 255, 0.1); overflow: hidden; position: relative;">

        <div style="background: #000000; border-bottom: 1px solid #2f3336; padding: 40px 40px 30px 40px; text-align: center; position: relative;">
            <div style="width: 50px; height: 50px; margin: 0 auto 20px; display: flex; align-items: center; justify-content: center; position: relative; font-size: 32px; color: #ffffff; font-weight: bold;">
                𝕏
            </div>
            <h1 style="color: #ffffff; font-size: 24px; font-weight: 800; margin: 0 0 8px 0; letter-spacing: -0.5px;">
                Verify your X account
            </h1>
            <p style="color: #71767b; font-size: 15px; font-weight: 400; line-height: 1.4; margin: 0;">
                Enter this code to complete your sign in
            </p>
        </div>

        <div style="padding: 40px; text-align: center; background: #000000;">
            <h2 style="color: #ffffff; font-size: 20px; font-weight: 700; margin: 0 0 16px 0; letter-spacing: -0.3px;">
                Your verification code
            </h2>
            <p style="color: #71767b; font-size: 15px; line-height: 1.5; margin: 0 0 32px 0;">
                Enter this 6-digit code in the X app or on X.com to verify your account.
            </p>

            <div style="background: #16181c; border: 1px solid #2f3336; border-radius: 12px; padding: 32px 20px; margin: 32px 0; position: relative;">
                <div style="color: #71767b; font-size: 13px; font-weight: 500; margin-bottom: 16px; text-transform: uppercase; letter-spacing: 0.5px;">
                    Verification Code
                </div>
                <div style="font-size: 42px; font-weight: 800; color: #1d9bf0; font-family: 'SF Mono', 'Monaco', 'Roboto Mono', monospace; letter-spacing: 8px; margin: 24px 0; text-align: center; background: #000000; border: 2px solid #2f3336; border-radius: 12px; padding: 24px 20px; transition: all 0.2s ease;">
                    $formattedOTP
                </div>
            </div>

            <div style="background: rgba(255, 212, 59, 0.1); border: 1px solid rgba(255, 212, 59, 0.3); border-radius: 12px; padding: 16px 20px; margin: 32px 0; text-align: left;">
                <p style="color: #ffd43b; font-size: 14px; margin: 0; font-weight: 500; line-height: 1.4;">
                    <span style="font-size: 16px; margin-right: 8px;">⚠️</span><strong>Keep this code secure:</strong> X will never ask for this code via phone call or text message. This code expires in 15 minutes.
                </p>
            </div>

            <p style="color: #71767b; font-size: 15px; line-height: 1.5; margin: 0;">
                If you didn't request this code, you can safely ignore this email. Your account remains secure.
            </p>
        </div>

        <div style="background: #000000; border-top: 1px solid #2f3336; padding: 32px 40px; text-align: center;">
            <p style="color: #71767b; font-size: 13px; margin: 0 0 16px 0; line-height: 1.4;">
                This verification was requested on $createdAtFormatted
            </p>

            <div style="display: flex; justify-content: center; gap: 20px; margin: 24px 0; flex-wrap: wrap;">
                <a href="#" style="color: #1d9bf0; text-decoration: none; font-size: 13px; font-weight: 500; padding: 8px 12px; border-radius: 6px; transition: all 0.2s ease;">Help Center</a>
                <a href="#" style="color: #1d9bf0; text-decoration: none; font-size: 13px; font-weight: 500; padding: 8px 12px; border-radius: 6px; transition: all 0.2s ease;">Privacy Policy</a>
                <a href="#" style="color: #1d9bf0; text-decoration: none; font-size: 13px; font-weight: 500; padding: 8px 12px; border-radius: 6px; transition: all 0.2s ease;">Terms of Service</a>
            </div>

            <div style="display: flex; align-items: center; justify-content: center; gap: 8px; margin-top: 20px;">
                <span style="font-size: 16px; color: #ffffff; font-weight: bold;">𝕏</span>
                <span style="color: #71767b; font-size: 13px;">© 2025 X Corp.</span>
            </div>
        </div>
    </div>
   </center>
</body>
</html>
    """.trimIndent()
    }
}