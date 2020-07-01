package com.devis.alodoktertest.core.base

import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.devis.alodoktertest.core.utils.ProgressDialog

/**
 * Created by devis on 30/06/20
 */

abstract class BaseActivity : AppCompatActivity() {

    private var mProgressDialog: ProgressDialog? = null

    @LayoutRes
    abstract fun layout(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    fun startLoading() {
        try {
            mProgressDialog = ProgressDialog()
            mProgressDialog!!.show(supportFragmentManager, "loading")
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        }
    }

    fun stopLoading() {
        try {
            if (mProgressDialog != null) {
                mProgressDialog!!.cancel()
            }
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        }
    }

}