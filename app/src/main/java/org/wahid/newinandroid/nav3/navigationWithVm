@Serializable
sealed interface ScreenKey : NavKey {
    @Serializable object List : ScreenKey
    @Serializable data class Detail(val itemId: String) : ScreenKey
}

class DetailViewModel : ViewModel() {
    var clickCount by mutableStateOf(0)
    fun onClicked() { clickCount++ }

    init {
        Log.e("LOG", "DetailViewModel init")
    }

    override fun onCleared() {
        super.onCleared()
        Log.e("LOG", "DetailViewModel Cleared")
    }
}

class BasicActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigator()
        }
    }
}

@Composable
fun AppNavigator() {
    val backStack = rememberNavBackStack(ScreenKey.List)
    val navTo: (ScreenKey) -> Unit = { backStack.add(it) }
    val goBack: () -> Unit = { if (backStack.size > 1) backStack.removeLastOrNull() }

    NavDisplay(
        backStack = backStack,
        onBack = { steps -> repeat(steps) { goBack() } },
        entryDecorators = listOf(
            rememberSceneSetupNavEntryDecorator(),
            rememberSavedStateNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        transitionSpec = {
            slideInHorizontally(animationSpec = tween(300)) + fadeIn() togetherWith
                    slideOutHorizontally(targetOffsetX = { -it }, animationSpec = tween(300)) + fadeOut()
        },
        popTransitionSpec = {
            slideInHorizontally(animationSpec = tween(300)) + fadeIn() togetherWith
                    slideOutHorizontally(animationSpec = tween(300)) + fadeOut()
        },
        entryProvider = entryProvider {
            entry<ScreenKey.List> {
                ListScreen(onItemSelected = navTo)
            }
            entry<ScreenKey.Detail> { key ->
                val vm: DetailViewModel = viewModel()
                DetailScreen(
                    itemId = key.itemId,
                    vm = vm,
                    onBack = goBack
                )
            }
        }
    )
}

@Composable
fun ListScreen(onItemSelected: (ScreenKey) -> Unit) {
    Column(
        Modifier
            .padding(all = 24.dp)
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Item List", style = MaterialTheme.typography.headlineSmall)
        listOf("A", "B", "C").forEach { id ->
            Button(onClick = { onItemSelected(ScreenKey.Detail(id)) }) {
                Text("Go to Detail for $id")
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun DetailScreen(
    itemId: String,
    vm: DetailViewModel,
    onBack: () -> Unit
) {
    val animatedCount by animateIntAsState(
        targetValue = vm.clickCount,
        animationSpec = tween(durationMillis = 300)
    )

    Column(
        Modifier
            .padding(all = 24.dp)
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Detail: $itemId", style = MaterialTheme.typography.headlineSmall)
        Text("Clicks: $animatedCount", style = MaterialTheme.typography.bodyLarge)
        Button(onClick = { vm.onClicked() }) {
            Text("Increment")
        }
        Button(onClick = onBack) {
            Text("Back")
        }
    }
}
