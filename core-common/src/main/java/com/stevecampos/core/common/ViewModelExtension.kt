package com.stevecampos.core.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


fun <T> ViewModel.executeTask(
    onSuccess: (T) -> Unit,
    onFailure: (ErrorEntity) -> Unit,
    task: suspend () -> Result<T>,
) {
    viewModelScope.launch(Dispatchers.IO) {
        try {
            val result = task.invoke()

            withContext(Dispatchers.Main) {
                when (result) {
                    is Result.Success -> onSuccess.invoke(result.data)
                    is Result.Error -> onFailure.invoke(result.error)
                }
            }
        } catch (e: Throwable) {
            withContext(Dispatchers.Main) {
                onFailure.invoke(ErrorEntity.Unknown)
            }
        }
    }
}