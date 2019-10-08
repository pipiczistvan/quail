package com.github.pipiczistvan.quail.ui.fragment.splash.tree

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TreeListFragmentArgument(val availableTreeIds: List<Int>): Parcelable
