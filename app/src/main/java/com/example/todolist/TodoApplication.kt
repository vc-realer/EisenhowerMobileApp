// app/src/main/java/com/example/todolist/TodoApplication.kt
package com.example.todolist

import android.app.Application
import com.example.todolist.data.AppDatabase
import com.example.todolist.data.TaskRepository

class TodoApplication : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { TaskRepository(database.taskDao()) }
}