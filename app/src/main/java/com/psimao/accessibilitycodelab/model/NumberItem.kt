package com.psimao.accessibilitycodelab.model

import java.io.Serializable

data class NumberItem(
        var number: Int,
        var description: String,
        var color: Int
) : Serializable