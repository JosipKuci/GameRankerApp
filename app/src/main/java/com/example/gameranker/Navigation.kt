package com.example.gameranker

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.gameranker.data.UserRanksViewModel
import com.example.gameranker.ui.theme.AboutScreen
import com.example.gameranker.ui.theme.AddNewListScreen
import com.example.gameranker.ui.theme.GameScreen
import com.example.gameranker.ui.theme.MainScreen
import com.example.gameranker.ui.theme.NewGameScreen
import com.example.gameranker.ui.theme.UserGameScreen
import com.example.gameranker.ui.theme.UserListScreen
import com.example.gameranker.ui.theme.UserRankingScreen

object Routes {
    const val SCREEN_ALL_GAMES = "gameList"
    const val SCREEN_NEW_LIST = "newList"
    const val SCREEN_NEW_GAME = "newGame"
    const val SCREEN_GAME_DETAILS = "gameDetails/{gameId}"
    const val SCREEN_ABOUT = "about"
    const val SCREEN_USER_LISTS = "userList"
    const val SCREEN_LIST_DETAILS = "listDetails/{listId}"
    const val SCREEN_USER_GAME_DETAILS = "listDetails/{listId}/{userGameId}"
    fun getGameDetailsPath(gameId: Int?) : String {
        if (gameId != null && gameId != -1) {
            return "gameDetails/$gameId"
        }
        return "gameDetails/0"
    }
    fun getListDetailsPath(listId: String?) : String {
        if (listId != null ) {
            return "listDetails/$listId"
        }
        return "listDetails/0"
    }
    fun getUserGameDetailsPath(listId: String?,gameId:Int) : String {
        if (listId != null && gameId!=null) {
            return "listDetails/$listId/$gameId"
        }
        return "listDetails/0/0"
    }
}
@Composable
fun NavigationController(viewModel: UserRanksViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination =
    Routes.SCREEN_ALL_GAMES) {
        composable(Routes.SCREEN_ALL_GAMES) {
            MainScreen(navigation = navController)
        }
        composable(Routes.SCREEN_ABOUT) {
            AboutScreen(navigation = navController)
        }
        composable(Routes.SCREEN_NEW_LIST) {
            AddNewListScreen(navigation = navController, viewModel = viewModel)
        }
        composable(Routes.SCREEN_NEW_GAME)
        {
            NewGameScreen(navigation = navController, viewModel = viewModel)
        }
        composable(Routes.SCREEN_USER_LISTS) {
            UserRankingScreen(navigation = navController, viewModel = viewModel)
        }
        composable(
            Routes.SCREEN_GAME_DETAILS,
            arguments = listOf(
                navArgument("gameId") {
                    type = NavType.IntType
                }
            )
        ) {backStackEntry ->
            backStackEntry.arguments?.getInt("gameId")?.let {
                GameScreen(
                    navigation = navController,
                    gameId = it
                )
            }
        }
        composable(
            Routes.SCREEN_LIST_DETAILS,
            arguments = listOf(
                navArgument("listId") {
                    type = NavType.StringType
                }
            )
        ) {backStackEntry ->
            backStackEntry.arguments?.getString("listId")?.let {
                UserListScreen(
                    navigation = navController,
                    viewModel = viewModel,
                    Id=it
                )
            }
        }
        composable(
            Routes.SCREEN_USER_GAME_DETAILS,
            arguments = listOf(
                navArgument("userGameId") {
                    type = NavType.IntType
                },
                        navArgument("listId") {
                    type = NavType.StringType
                }
            )
        ) {backStackEntry ->
            val rank = backStackEntry.arguments?.getInt("userGameId")
            val list = backStackEntry.arguments?.getString("listId")
            val fun_rank:Int
            val fun_list:String
            if(rank==null)
            {
                fun_rank=0
            }
            else
            {
                fun_rank=rank
            }
            if(list==null)
            {
                fun_list=""
            }
            else
            {
                fun_list=list
            }
                UserGameScreen(
                    navigation = navController,
                    gameRank = fun_rank,
                    Id=fun_list,
                    viewModel = viewModel
                )
        }


    }
}