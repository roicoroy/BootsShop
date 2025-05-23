package org.goiaba.boot.shop

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform