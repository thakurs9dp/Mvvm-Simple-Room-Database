package com.s9dp.mvvm_room_database_simple.MVVM_2.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.s9dp.mvvm_room_database_simple.MVVM_2.model.Todo
import com.s9dp.mvvm_room_database_simple.MVVM_2.model.TodoDatabase
import com.s9dp.mvvm_room_database_simple.MVVM_2.model.TodoRepository
import com.s9dp.mvvm_room_database_simple.MVVM_2.modelview.TodoViewModel
import com.s9dp.mvvm_room_database_simple.MVVM_2.modelview.TodoViewModelFactory
import com.s9dp.mvvm_room_database_simple.R

class TodoActivity : AppCompatActivity() {

    private lateinit var todoViewModel: TodoViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)


        val dao = TodoDatabase.getDatabase(application).getTodoDao()
        val repository = TodoRepository(dao)
        val factory = TodoViewModelFactory(repository)

        todoViewModel = ViewModelProvider(this, factory)[TodoViewModel::class.java]

        todoViewModel.insertTodo(
            Todo(
                id = 1, title = "Abc", note = "Moto Pa", date = "16-12-12"
            )
        )

        todoViewModel.allTodo.observe(this) { todos ->
            // Update UI with the list of todos

            for (i in todos) {
                Log.d("ABC_TEST", i.note)
                Toast.makeText(this, "Response ${i.note}", Toast.LENGTH_LONG).show()
            }

        }

    }

}