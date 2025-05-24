package org.wahid.newinandroid.nav3

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
        modifier = modifier,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Home> { key ->
                    HomeScreen(modifier = Modifier.fillMaxSize()) { backStack.add(Details("Android is awesome")) }
            }
            entry<Details> { key ->
                    DetailsScreen(modifier = Modifier.fillMaxSize(), text = key.name)

            }
        }
    )

}


@Composable
fun HomeScreen(modifier: Modifier = Modifier, onClickNext: () -> Unit) {
    Scaffold {
        val pd = it
        Box(
            modifier = modifier
                .padding(pd)
                .clickable(onClick = onClickNext),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Welcome to Navigation3, You're in Home Screen",
                color = Color.DarkGray
            )
        }
    }
}

@Composable
fun DetailsScreen(modifier: Modifier = Modifier, text: String) {

    Scaffold {
        val pd = it
        Box(
            modifier = modifier.padding(pd),
            contentAlignment = Alignment.Center
        )
        {
            Text(
                text = "Welcome to Navigation3, You're in Details Screen\n$text",
                color = Color.DarkGray
            )
        }
    }

}