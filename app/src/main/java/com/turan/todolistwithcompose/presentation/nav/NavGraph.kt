package com.turan.todolistwithcompose.presentation.nav

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.turan.todolistwithcompose.presentation.screens.*
import com.turan.todolistwithcompose.presentation.screens.login.LoginScreen

@Composable
fun ToDoNavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(navController)
        }
        composable(Screen.Login.route) {
            LoginScreen(navController)
        }
        composable(Screen.TaskList.route) {
            TaskListScreen(navController)
        }
        composable(
            route = Screen.AddEditTask.route + "?taskId={taskId}",
            arguments = listOf(navArgument("taskId") {
                type = NavType.StringType
                nullable = true
                defaultValue = null
            })
        ) {
            val taskId = it.arguments?.getString("taskId")
            AddEditTaskScreen(navController, taskId)
        }
        composable(Screen.Stats.route) {
            StatsScreen(navController)
        }
    }
}
