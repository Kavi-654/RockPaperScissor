import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.rockpaperscissor.ui.screens.GameScreen
import com.example.rockpaperscissor.ui.screens.HomeScreen
import com.example.rockpaperscissor.ui.screens.LanguageChoose
import com.example.rockpaperscissor.ui.screens.ProfileScreen
import com.example.rockpaperscissor.ui.screens.RulesScreen
import com.example.rockpaperscissor.viewmodel.GameViewModel


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val gameViewModel: GameViewModel = viewModel() // One ViewModel to rule them all

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(onNext = { navController.navigate(Screen.Language.route) })
        }

        composable(Screen.Language.route) {
            LanguageChoose(onNext = { navController.navigate(Screen.Profile.route) })
        }

        composable(Screen.Profile.route) {
            ProfileScreen(
                viewModel = gameViewModel,
                onNext = { navController.navigate(Screen.Rules.route) }
            )
        }

        composable(Screen.Rules.route) {
            RulesScreen(modifier = Modifier,
                onNext = { navController.navigate(Screen.Game.route) }
            )
        }

        composable(Screen.Game.route) {
            GameScreen(viewModel = gameViewModel)
        }
    }
}