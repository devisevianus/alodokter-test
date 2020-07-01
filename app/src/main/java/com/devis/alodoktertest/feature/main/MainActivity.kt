package com.devis.alodoktertest.feature.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.devis.alodoktertest.R
import com.devis.alodoktertest.core.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main_v2.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by devis on 01/07/20
 */

class MainActivity : BaseActivity() {

    companion object {
        fun startThisActivity(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    private var mClickBackCounter = 0

    override fun layout(): Int {
        return R.layout.activity_main_v2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initToolbar()
        initNavigation()
    }

    override fun onBackPressed() {
        mClickBackCounter++

        this.lifecycleScope.launch {
            if (mClickBackCounter > 1) {
                finishAffinity()
                mClickBackCounter = 0
            } else {
                Toast.makeText(
                    this@MainActivity,
                    resources.getString(R.string.message_exit_app),
                    Toast.LENGTH_SHORT).show()
            }
            delay(2000)
            mClickBackCounter = 0
        }
    }

    private fun initToolbar() {
        tv_toolbar_title.text = resources.getString(R.string.app_name)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    private fun initNavigation() {
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.profileFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        bnv_menu.setupWithNavController(navController)
    }

}