package com.s9dp.mvvm_room_database_simple.MVVM_2.modelview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.s9dp.mvvm_room_database_simple.MVVM_2.model.Todo
import com.s9dp.mvvm_room_database_simple.MVVM_2.model.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//https://developer.android.com/codelabs/android-room-with-a-view-kotlin#6

class TodoViewModel(private val repository: TodoRepository) : ViewModel() {

    val allTodo: LiveData<List<Todo>> = repository.allTodos

    fun insertTodo(todo: Todo) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(todo)
    }

    fun updateTodo(todo: Todo) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(todo)
    }

    fun deleteTodo(todo: Todo) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(todo)
    }
}
