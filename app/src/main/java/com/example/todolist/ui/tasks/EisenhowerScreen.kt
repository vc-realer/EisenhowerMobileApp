// app/src/main/java/com/example/todolist/ui/tasks/EisenhowerScreen.kt
package com.example.todolist.ui.tasks

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todolist.GreetingImage
import com.example.todolist.TodoApplication
import com.example.todolist.ui.components.MyAppBar
import com.example.todolist.ui.components.Quadrant
import com.example.todolist.ui.viewmodels.TaskViewModel
import com.example.todolist.ui.viewmodels.TaskViewModelFactory

@Composable
fun EisenhowerScreen(
    onAddTask: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: TaskViewModel = getTaskViewModel()
) {

    Scaffold(
//        floatingActionButton = {
//            FloatingActionButton(onClick = onAddTask) {
//                Icon(Icons.Default.Add, contentDescription = "Add Task")
//            }
//        }
    ) { padding ->
        GreetingImage()
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(padding)
        ) {

            Text(
                text = "Eisenhower Matrix",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally),
                color = Color.White
            )
            // Matrix Grid

            Column(modifier = Modifier.fillMaxSize()) {
                // Row 1: Quadrant 1 and 2
                Row(modifier = Modifier.weight(1f)) {
                    // Quadrant 1: Urgent & Important
                    val q1Tasks by viewModel.quadrant1Tasks.collectAsState(initial = emptyList())
                    Quadrant(
                        title = "Do First",
                        tasks = q1Tasks,
                        onTaskChecked = { task, checked ->
                            viewModel.updateTask(task.copy(isCompleted = checked))
                        },
                        onDeleteTask = { task ->
                            viewModel.deleteTask(task)
                        },
                        modifier = Modifier.weight(1f),
                        backgroundColor = Color(0xFF3D6CB9)
                    )

                    // Quadrant 2: Not Urgent & Important
                    val q2Tasks by viewModel.quadrant2Tasks.collectAsState(initial = emptyList())
                    Quadrant(
                        title = "Schedule",
                        tasks = q2Tasks,
                        onTaskChecked = { task, checked ->
                            viewModel.updateTask(task.copy(isCompleted = checked))
                        },
                        onDeleteTask = { task ->
                            viewModel.deleteTask(task)
                        },
                        modifier = Modifier.weight(1f),
                        backgroundColor = Color(0xFF00D1FF)

                    )
                }

                // Row 2: Quadrant 3 and 4
                Row(modifier = Modifier.weight(1f)) {
                    // Quadrant 3: Urgent & Not Important
                    val q3Tasks by viewModel.quadrant3Tasks.collectAsState(initial = emptyList())
                    Quadrant(
                        title = "Delegate",
                        tasks = q3Tasks,
                        onTaskChecked = { task, checked ->
                            viewModel.updateTask(task.copy(isCompleted = checked))
                        },
                        onDeleteTask = { task ->
                            viewModel.deleteTask(task)
                        },
                        modifier = Modifier.weight(1f),
                        backgroundColor = Color(0xFF00FFF0)

                    )

                    // Quadrant 4: Not Urgent & Not Important
                    val q4Tasks by viewModel.quadrant4Tasks.collectAsState(initial = emptyList())
                    Quadrant(
                        title = "Don't Do",
                        tasks = q4Tasks,
                        onTaskChecked = { task, checked ->
                            viewModel.updateTask(task.copy(isCompleted = checked))
                        },
                        onDeleteTask = { task ->
                            viewModel.deleteTask(task)
                        },
                        modifier = Modifier.weight(1f),
                        backgroundColor = Color(0xFFFAFAF6)

                    )
                }
                MyAppBar(onButton1Click = onAddTask)

            }

        }
    }
}

@Composable
fun getTaskViewModel(): TaskViewModel {
    val context = LocalContext.current
    val application = context.applicationContext as TodoApplication
    return viewModel(
        factory = TaskViewModelFactory(application.repository)
    )
}