package com.turan.todolistwithcompose.presentation.nav

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Login : Screen("login")
    object TaskList : Screen("task_list")
    object AddEditTask : Screen("add_edit_task")
    object Stats : Screen("stats")
}