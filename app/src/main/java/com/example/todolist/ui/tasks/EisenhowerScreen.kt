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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todolist.data.TaskRepository
import com.example.todolist.ui.components.Quadrant

// ui/tasks/EisenhowerScreen.kt
@Composable
fun EisenhowerScreen(
    onAddTask: () -> Unit,
    modifier: Modifier = Modifier
) {
    val tasks by remember { mutableStateOf(TaskRepository.tasks) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onAddTask) {
                Icon(Icons.Default.Add, contentDescription = "Add Task")
            }
        }
    ) { padding ->
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
                    .align(Alignment.CenterHorizontally)
            )

            // Matrix Grid
            Column(modifier = Modifier.fillMaxSize()) {
                // Row 1: Quadrant 1 and 2
                Row(modifier = Modifier.weight(1f)) {
                    // Quadrant 1: Urgent & Important
                    Quadrant(
                        title = "Do First",
                        tasks = TaskRepository.getTasksByQuadrant(1),
                        onTaskChecked = { task, checked ->
                            TaskRepository.updateTask(task.copy(isCompleted = checked))
                        },
                        onDeleteTask = { task ->
                            TaskRepository.deleteTask(task)
                        },
                        modifier = Modifier.weight(1f)
                    )

                    // Quadrant 2: Not Urgent & Important
                    Quadrant(
                        title = "Schedule",
                        tasks = TaskRepository.getTasksByQuadrant(2),
                        onTaskChecked = { task, checked ->
                            TaskRepository.updateTask(task.copy(isCompleted = checked))
                        },
                        onDeleteTask = { task ->
                            TaskRepository.deleteTask(task)
                        },
                        modifier = Modifier.weight(1f)
                    )
                }

                // Row 2: Quadrant 3 and 4
                Row(modifier = Modifier.weight(1f)) {
                    // Quadrant 3: Urgent & Not Important
                    Quadrant(
                        title = "Delegate",
                        tasks = TaskRepository.getTasksByQuadrant(3),
                        onTaskChecked = { task, checked ->
                            TaskRepository.updateTask(task.copy(isCompleted = checked))
                        },
                        onDeleteTask = { task ->
                            TaskRepository.deleteTask(task)
                        },
                        modifier = Modifier.weight(1f)
                    )

                    // Quadrant 4: Not Urgent & Not Important
                    Quadrant(
                        title = "Don't Do",
                        tasks = TaskRepository.getTasksByQuadrant(4),
                        onTaskChecked = { task, checked ->
                            TaskRepository.updateTask(task.copy(isCompleted = checked))
                        },
                        onDeleteTask = { task ->
                            TaskRepository.deleteTask(task)
                        },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}