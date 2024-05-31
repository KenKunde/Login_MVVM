package com.example.login_mvvm.viewmodel

import android.text.TextUtils
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    private val _toastMessage = MutableLiveData<String?>()
    val toastMessage: LiveData<String?>
        get() = _toastMessage

    fun onLoginClicked() {
        if (isValid()) {
            _toastMessage.value = "Login successful"
        } else {
            _toastMessage.value = "Email or Password is not valid"
        }
    }

    private fun isValid(): Boolean {
        return !TextUtils.isEmpty(email.value) && Patterns.EMAIL_ADDRESS.matcher(email.value ?: "").matches()
                && (password.value?.length ?: 0) > 5
    }

    fun onToastMessageShown() {
        _toastMessage.value = null
    }
}
