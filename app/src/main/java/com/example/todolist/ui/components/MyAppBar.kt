package com.example.todolist.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBar(
    onButton1Click: () -> Unit
) {

    TopAppBar(
        title = {
            Text(text = "My App", color = Color.White)
        },
        actions = {
            IconButton(onClick = onButton1Click, Modifier.width(80.dp).height(80.dp).padding(end = 10.dp, bottom = 10.dp)) {
                Icon(Icons.Default.Add, contentDescription = "Add", Modifier.width(60.dp).height(60.dp))
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF3D6CB9) // Background color
        ),
        modifier = Modifier
            .height(80.dp)
    )


}