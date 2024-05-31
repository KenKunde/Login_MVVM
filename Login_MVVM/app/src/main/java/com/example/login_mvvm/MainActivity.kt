package com.example.login_mvvm

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.login_mvvm.databinding.ActivityMainBinding
import com.example.login_mvvm.viewmodel.LoginViewModel

class MainActivity : AppCompatActivity() {
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = loginViewModel
        binding.lifecycleOwner = this

        loginViewModel.toastMessage.observe(this) { message ->
            message?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                loginViewModel.onToastMessageShown()
            }
        }
    }
}
