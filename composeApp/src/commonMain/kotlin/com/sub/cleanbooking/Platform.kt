package com.sub.cleanbooking

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform