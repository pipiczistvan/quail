package com.github.pipiczistvan.quail.common.domain

import kotlinx.serialization.Serializable

@Serializable
data class Preload(
    val availableTreeIds: List<Int>
)
