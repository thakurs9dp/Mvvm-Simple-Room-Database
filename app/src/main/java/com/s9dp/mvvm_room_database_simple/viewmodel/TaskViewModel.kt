package com.s9dp.mvvm_room_database_simple.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.s9dp.mvvm_room_database_simple.model.localData.enties.Task
import com.s9dp.mvvm_room_database_simple.model.repository.TaskRepository

class TaskViewModel(application: Application) : AndroidViewModel(application) {

    private val taskRepository = TaskRepository(application)
    val taskStateFlow get() =  taskRepository.taskStateFlow
    val statusLiveData get() =  taskRepository.statusLiveData
    val sortByLiveData get() =  taskRepository.sortByLiveData

    fun setSortBy(sort:Pair<String,Boolean>){
        taskRepository.setSortBy(sort)
    }

    fun getTaskList(isAsc : Boolean, sortByName:String) {
        taskRepository.getTaskList(isAsc, sortByName)
    }

    fun insertTask(task: Task){
        taskRepository.insertTask(task)
    }

    fun deleteTask(task: Task) {
        taskRepository.deleteTask(task)
    }

    fun deleteTaskUsingId(taskId: String){
        taskRepository.deleteTaskUsingId(taskId)
    }

    fun updateTask(task: Task) {
        taskRepository.updateTask(task)
    }

    fun updateTaskParticularField(taskId: String, title:String, description:String) {
        taskRepository.updateTaskParticularField(taskId, title, description)
    }
    fun searchTaskList(query: String){
        taskRepository.searchTaskList(query)
    }
}