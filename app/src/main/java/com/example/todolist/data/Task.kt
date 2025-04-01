package com.example.todolist.data

data class Task(
    val id: Long = System.currentTimeMillis(),
    val title: String,
    val description: String = "",
    val isImportant: Boolean,
    val isUrgent: Boolean,
    val createdAt: Long = System.currentTimeMillis(),
    val isCompleted: Boolean = false
) {
    fun quadrant(): Int {
        return when {
            isImportant && isUrgent -> 1
            isImportant && !isUrgent -> 2
            !isImportant && isUrgent -> 3
            else -> 4
        }
    }
}