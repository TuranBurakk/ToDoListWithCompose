package com.turan.todolistwithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.turan.todolistwithcompose.presentation.nav.ToDoNavGraph
import com.turan.todolistwithcompose.ui.theme.ToDoListWithComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDoListWithComposeTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    ToDoNavGraph(
                        navController = navController ,
                        paddingValues = innerPadding
                    )
                }
            }
        }
    }
}
