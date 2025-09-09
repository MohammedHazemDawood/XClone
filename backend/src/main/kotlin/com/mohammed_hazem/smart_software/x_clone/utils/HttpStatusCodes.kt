package com.mohammed_hazem.smart_software.x_clone.utils

import org.springframework.http.HttpStatusCode

object HttpStatusCodes {
    val OK = HttpStatusCode.valueOf(200)
    val BAD_REQUEST = HttpStatusCode.valueOf(400)
    val NOT_FOUND = HttpStatusCode.valueOf(404)
    val CONFLICT = HttpStatusCode.valueOf(404)
    val INTERNAL_SERVER_ERROR = HttpStatusCode.valueOf(500)
    val BAD_GATEWAY = HttpStatusCode.valueOf(502)
    val SERVER_UNAVILABLE = HttpStatusCode.valueOf(503)
}