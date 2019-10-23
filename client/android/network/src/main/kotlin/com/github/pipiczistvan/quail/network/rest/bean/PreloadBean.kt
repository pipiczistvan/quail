@file:UseSerializers(DateSerializer::class)

package com.github.pipiczistvan.quail.network.rest.bean

import DateSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import java.util.*

@Serializable
data class PreloadBean(
    val availablePreviews: List<AvailablePreview>
) {
    @Serializable
    data class AvailablePreview(val id: Int, val lastModified: Date)
}
