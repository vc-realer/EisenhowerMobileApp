package com.example.todolist.data

object TaskRepository {
    private val _tasks = mutableListOf<Task>()
    val tasks: List<Task> get() = _tasks

    fun addTask(task: Task) {
        _tasks.add(task)
    }

    fun updateTask(task: Task) {
        val index = _tasks.indexOfFirst { it.id == task.id }
        if (index != -1) {
            _tasks[index] = task
        }
    }

    fun deleteTask(task: Task) {
        _tasks.remove(task)
    }

    fun getTasksByQuadrant(quadrant: Int): List<Task> {
        return _tasks.filter { it.quadrant() == quadrant }
    }
}