package com.br.introduction.presentation.warningmessage

interface OnWarningPhoneListener {
    fun onNegativeButton(callback: () -> Unit)
    fun onPositiveButton(callback: () -> Unit)
}