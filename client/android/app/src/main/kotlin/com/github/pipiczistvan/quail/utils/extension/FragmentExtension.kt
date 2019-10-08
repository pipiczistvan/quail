package com.github.pipiczistvan.quail.utils.extension

import androidx.activity.addCallback
import androidx.fragment.app.Fragment

fun Fragment.disableBackButton() {
    requireActivity().onBackPressedDispatcher.addCallback(this) {}
}
