@file:UseSerializers(DateSerializer::class)

package com.github.pipiczistvan.quail.common.domain

import com.github.pipiczistvan.quail.common.utils.DateSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import java.util.*

@Serializable
data class Preload(
    val availablePreviews: List<AvailablePreview>
) {
    @Serializable
    data class AvailablePreview(val id: Int, val lastModified: Date)
}
