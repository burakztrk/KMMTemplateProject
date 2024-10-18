package com.sub.cleanbooking

import com.sub.cleanbooking.di.Modules
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(
            Modules.repositories,
            Modules.viewModels
        )
    }
}