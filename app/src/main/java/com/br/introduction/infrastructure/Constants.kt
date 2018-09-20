package com.br.introduction.infrastructure

class Constants {

    interface AnalyticsContextName {
        companion object {
            val SCREEN_VIEWS = "Visualização de telas"
            val INTRO = "Introdução"
        }
    }

    interface AnalyticsEventKeys {
        companion object {
            val SCREENS = "Telas"
            val ACCESS_ACCOUNT = "Acessar conta"
            val CREATE_ACCOUNT = "Criar conta"
        }
    }

    interface AnalyticsParams {
        companion object {
            val COUNT = "Contagem"
            val CAROUSEL = "Carrossel"
        }
    }
}