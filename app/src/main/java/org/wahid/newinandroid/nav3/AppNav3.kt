package org.wahid.newinandroid.nav3

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay

@Composable
fun AppNav3(modifier: Modifier) {

    //DON'T forgot to change your activityCompose TO "1.12.0-alpha01" to avoid dispatcher errors
    val backStack = remember { mutableStateListOf<Any>(Home) }

    NavDisplay(
        backStack = backStack,
        modifier = modifier.fillMaxSize(),
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider{
            entry<Home> {key->
                HomeScreen { backStack.add(Details("Android is awesome")) }
            }
            entry<Details> {key->
                DetailsScreen(modifier = modifier, text = key.name)
            }
        }
    )

}


@Composable
fun HomeScreen(modifier: Modifier = Modifier, onClickNext: () -> Unit) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    )
    {
        Text(
            text = "Welcome to Navigation3, You're in Home Screen",
            modifier = Modifier.clickable(onClick = onClickNext)
        )
    }
}

@Composable
fun DetailsScreen(modifier: Modifier = Modifier, text: String) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    )
    {
        Text(text = "Welcome to Navigation3, You're in Details Screen\n$text")
    }
}