package com.devis.alodoktertest.core.helper

import android.content.Context
import android.content.SharedPreferences
import com.devis.alodoktertest.core.model.UserMdl
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by devis on 01/07/20
 */

class PrefHelper(private val context: Context) {

    companion object {
        private const val PREF_NAME = "pref_alodokter_test"
        private const val PREF_USER_DATA = "pref_user_data"
    }

    private fun pref(): SharedPreferences {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun saveUserData(data: UserMdl?) {
        data.apply {
            pref().edit().putString(PREF_USER_DATA, Gson().toJson(this)).apply()
        }
    }

    fun getUserData(): UserMdl? {
        val json = pref().getString(PREF_USER_DATA, null)
        var data: UserMdl? = null
        json?.apply {
            data = Gson().fromJson(this, object : TypeToken<UserMdl>() {}.type)
        }

        return data
    }

    fun clear() {
        saveUserData(null)
    }

}