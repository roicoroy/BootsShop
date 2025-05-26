package org.goiaba.boots.shop.di

import org.goiaba.boot.shop.auth.MyAuthViewModel
import org.goiaba.boots.shop.data.AdminRepositoryImpl
import org.goiaba.boots.shop.data.OrderRepositoryImpl
import org.goiaba.boots.shop.data.ProductRepositoryImpl
import org.goiaba.boots.shop.data.domain.AdminRepository
import org.goiaba.boots.shop.data.domain.CustomerRepository
import org.goiaba.boots.shop.data.domain.CustomerRepositoryImpl
import org.goiaba.boots.shop.data.domain.OrderRepository
import org.goiaba.boots.shop.data.domain.ProductRepository
import org.goiaba.boots.shop.shared.utils.IntentHandler
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val sharedModule = module {
    single<CustomerRepository> { CustomerRepositoryImpl() }
    single<AdminRepository> { AdminRepositoryImpl() }
    single<ProductRepository> { ProductRepositoryImpl() }
    single<OrderRepository> { OrderRepositoryImpl(get()) }
    single<IntentHandler> { IntentHandler() }
//    single<PaypalApi> { PaypalApi() }
//    viewModelOf(::MyAuthViewModel)
//    viewModelOf(::HomeGraphViewModel)
//    viewModelOf(::ProfileViewModel)
//    viewModelOf(::ManageProductViewModel)
//    viewModelOf(::AdminPanelViewModel)
//    viewModelOf(::ProductsOverviewViewModel)
//    viewModelOf(::DetailsViewModel)
//    viewModelOf(::CartViewModel)
//    viewModelOf(::CategorySearchViewModel)
//    viewModelOf(::CheckoutViewModel)
//    viewModelOf(::PaymentViewModel)
}

expect val targetModule: Module

fun initializeKoin(
    config: (KoinApplication.() -> Unit)? = null,
) {
    startKoin {
        config?.invoke(this)
        modules(sharedModule, targetModule)
    }
}