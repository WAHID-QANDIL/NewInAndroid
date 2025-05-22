package org.wahid.newinandroid.nav3

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data class Details(val name: String) : NavKey

@Serializable
data object Home : NavKey