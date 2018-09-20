package com.br.introduction.infrastructure

abstract class OperationListener<T> {

    fun onSuccess(result: T) {}

    fun onError(error: Int) {}

    fun onCancel() {}

    fun onProgressUpdate(progress: Int) {}
}
