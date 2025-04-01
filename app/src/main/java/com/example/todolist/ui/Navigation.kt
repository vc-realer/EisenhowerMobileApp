package com.example.todolist.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todolist.ui.tasks.AddTaskScreen
import com.example.todolist.ui.tasks.EisenhowerScreen

@Composable
fun EisenhowerNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "eisenhower"
    ) {
        composable("eisenhower") {
            EisenhowerScreen(
                onAddTask = { navController.navigate("addTask") }
            )
        }
        composable("addTask") {
            AddTaskScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}
