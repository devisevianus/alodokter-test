package com.devis.alodoktertest.feature.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.Observer
import com.devis.alodoktertest.core.base.BaseActivity
import com.devis.alodoktertest.BuildConfig
import com.devis.alodoktertest.R
import com.devis.alodoktertest.core.base.BaseViewState
import com.devis.alodoktertest.core.helper.PrefHelper
import com.devis.alodoktertest.core.utils.isValidEmail
import com.devis.alodoktertest.core.utils.isValidPassword
import com.devis.alodoktertest.feature.main.MainActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Created by devis on 30/06/20
 */

class LoginActivity : BaseActivity() {

    companion object {
        fun startThisActivity(context: Context) {
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        }
    }

    private lateinit var mViewModel: LoginViewModel

    private var isValidEmail = false
    private var isValidPassword = false


    override fun layout(): Int {
        return R.layout.activity_login
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewModel = LoginViewModel()

        val userData = PrefHelper(this).getUserData()
        if (userData != null) {
            MainActivity.startThisActivity(this)
            finish()
        }

        initView()
        initViewAction()
        initObserve()
    }

    private fun initView() {
        tv_app_version.text = String.format(
            resources.getString(R.string.placeholder_app_version),
            BuildConfig.VERSION_NAME
        )
        btn_login.isEnabled = false
    }

    private fun initViewAction() {
        et_email.addTextChangedListener(textWatcher(1))
        et_password.addTextChangedListener(textWatcher(2))

        btn_login.setOnClickListener {
            mViewModel.postLogin(
                email = et_email.text.toString(),
                password = et_password.text.toString()
            )
        }
    }

    private fun initObserve() {
        mViewModel.apply {
            loginResult.observe(this@LoginActivity, Observer {
                when (it) {
                    is BaseViewState.Loading -> {
                        startLoading()
                    }
                    is BaseViewState.Success -> {
                        stopLoading()
                        PrefHelper(this@LoginActivity).saveUserData(it.data)
                        MainActivity.startThisActivity(this@LoginActivity)
                        finish()
                    }
                    is BaseViewState.Error -> {
                        stopLoading()
                        Snackbar.make(
                            findViewById(android.R.id.content),
                            it.errorMessage,
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                }
            })
        }
    }

    /**
     * @param editTextId:
     * 1 = editText email id
     * 2 = editText password id
     */
    private fun textWatcher(editTextId: Int) = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            if (editTextId == 1) {
                if (!s.isNullOrEmpty() && !s.toString().isValidEmail()) {
                    til_email.error = "Please input valid email"

                } else {
                    til_email.error = ""
                }

                isValidEmail = !s.isNullOrEmpty() && s.toString().isValidEmail()
            } else if (editTextId == 2) {
                if (!s.isNullOrEmpty() && !s.toString().isValidPassword()) {
                    til_password.error = "Password must be at least 6 characters"

                } else {
                    til_password.error = ""
                }

                isValidPassword = !s.isNullOrEmpty() && s.toString().isValidPassword()
            }

            btn_login.isEnabled = isValidEmail && isValidPassword
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }
    }

}