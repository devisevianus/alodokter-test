package com.devis.alodoktertest.core.model

import java.io.Serializable

/**
 * Created by devis on 01/07/20
 */

class UserMdl : Serializable {
    private val name: String = "Devis Evianus"
    private val phoneNumber: String = "085711785383"
    private val email: String = "devisevianus7@gmail.com"
    private val dateOfBirth: String = "13 July 1996"

    fun getName(): String {
        return name
    }

    fun getPhoneNumber(): String {
        return phoneNumber
    }

    fun getEmail(): String {
        return email
    }

    fun getDateOfBirth(): String {
        return dateOfBirth
    }
}