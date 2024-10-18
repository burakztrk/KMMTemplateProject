package com.sub.cleanbooking.di

import com.sub.cleanbooking.DetailViewModel
import com.sub.cleanbooking.data.CountService
import com.sub.cleanbooking.data.CountServiceImpl
import org.koin.dsl.module

object Modules {
    val repositories = module {
        factory<CountService> { CountServiceImpl() }
    }

    val viewModels = module {
        factory { DetailViewModel(get()) }
    }
}