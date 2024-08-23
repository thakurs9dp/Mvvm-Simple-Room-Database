package com.s9dp.mvvm_room_database_simple.MVVM_2.modelview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.s9dp.mvvm_room_database_simple.MVVM_2.model.TodoRepository

class TodoViewModelFactory(private val repository: TodoRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TodoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TodoViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}