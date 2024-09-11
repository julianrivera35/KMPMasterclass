package andes.campus.analytic.pg

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform