package com.stevecampos.core.common

sealed class ErrorEntity {

    sealed class ApiError: ErrorEntity() {
        object Network : ErrorEntity()

        object NotFound : ErrorEntity()

        object AccessDenied : ErrorEntity()

        object ServiceUnavailable : ErrorEntity()

        //object Unknown : ErrorEntity()
    }

    object Unknown: ErrorEntity()

}