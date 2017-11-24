package com.psimao.accessibilitycodelab.extension

import android.graphics.Color
import java.util.*

fun generateRandomColor(): Int {
    val rand = Random()

    val r = rand.nextInt(255)
    val g = rand.nextInt(255)
    val b = rand.nextInt(255)

    return Color.rgb(r, g, b)
}