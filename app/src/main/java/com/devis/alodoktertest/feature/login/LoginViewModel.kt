package com.devis.alodoktertest.feature.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devis.alodoktertest.core.base.BaseViewState
import com.devis.alodoktertest.core.model.UserMdl
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by devis on 30/06/20
 */

class LoginViewModel : ViewModel() {

    private val _mLoginResult = MutableLiveData<BaseViewState<UserMdl>>()
    private val userEmail = "email.testing@email.com"
    private val userPassword = "password"

    private var isSuccessLogin = false

    val loginResult: LiveData<BaseViewState<UserMdl>> = _mLoginResult

    fun postLogin(email: String, password: String) {
        _mLoginResult.value = BaseViewState.Loading
        viewModelScope.launch {
            isSuccessLogin = email == userEmail && password == userPassword
            delay(2000)
            if (!isSuccessLogin) {
                _mLoginResult.value = BaseViewState.Error("Invalid email or password")
            } else {
                _mLoginResult.value = BaseViewState.Success(UserMdl())
            }
        }
    }

}