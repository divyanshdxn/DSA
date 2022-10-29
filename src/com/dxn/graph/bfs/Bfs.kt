package com.dxn.graph.bfs

fun main() {
    val graph = mapOf(
            1 to listOf(3, 5 ,2),
            2 to listOf(1,5),
            3 to listOf(1, 5, 4),
            4 to listOf(3,6),
            5 to listOf(1, 2, 3, 6),
            6 to listOf(4, 5)
    )
}