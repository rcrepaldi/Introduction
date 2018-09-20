package com.br.introduction.presentation.warningmessage

interface OnWarningDefaultListener {
    fun onNegativeButton(callback: () -> Unit)
    fun onPositiveButton(callback: () -> Unit)
}