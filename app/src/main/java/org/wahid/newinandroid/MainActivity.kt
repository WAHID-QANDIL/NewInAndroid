package org.wahid.newinandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.wahid.newinandroid.nav3.AppNav3
import org.wahid.newinandroid.ui.theme.NewInAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewInAndroidTheme {
                val remembercs = rememberCoroutineScope()
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    val pd = it;
                    AppNav3(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}
