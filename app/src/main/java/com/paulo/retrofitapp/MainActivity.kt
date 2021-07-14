package com.paulo.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.paulo.retrofitapp.databinding.ActivityMainBinding
import com.paulo.retrofitapp.ui.MainViewModel
import com.paulo.retrofitapp.ui.UserAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        userAdapter = UserAdapter(listOf())
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.recycler.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)

        }
        viewModel.run {
            getUsers()
            usersLiveData.observe(this@MainActivity,{ user ->
                userAdapter.users = user
                userAdapter.notifyDataSetChanged()
            })
        }


    }
}