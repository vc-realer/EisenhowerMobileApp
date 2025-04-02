package com.example.todolist.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.todolist.data.Task


@Composable
fun Quadrant(
    title: String,
    tasks: List<Task>,
    onTaskChecked: (Task, Boolean) -> Unit,
    onDeleteTask: (Task) -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(backgroundColor)
            .border(width = 5.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 8.dp, start = 10.dp, top = 5.dp)
        )

        LazyColumn {
            items(tasks) { task -> // 'tasks' should be a List<Task>
                TaskCard(
                    task = task,
                    onCheckedChange = { checked ->
                        onTaskChecked(task, checked)
                    },
                    onDelete = { onDeleteTask(task) }
                )
            }
        }

    }
}