package com.devis.alodoktertest.core.base

/**
 * Created by devis on 01/07/20
 */

sealed class BaseViewState<out R> {
    object Loading: BaseViewState<Nothing>()
    data class Error(val errorMessage: String): BaseViewState<Nothing>()
    data class Success<T>(val data: T?): BaseViewState<T>()
}