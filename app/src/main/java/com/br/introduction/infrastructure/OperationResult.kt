package com.br.introduction.infrastructure

class OperationResult<T> {

    var result: T? = null
    var error = NO_ERROR

    companion object {
        val NO_ERROR = -1
    }
}
