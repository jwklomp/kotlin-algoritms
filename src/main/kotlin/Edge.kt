package org.jwk

data class Edge<T>(
    val first: T,
    val second: T,
    val weight: Int
)
