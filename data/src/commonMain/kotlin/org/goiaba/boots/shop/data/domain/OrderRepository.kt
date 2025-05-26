package org.goiaba.boots.shop.data.domain

import org.goiaba.boots.shop.shared.domain.Order

interface OrderRepository {
    fun getCurrentUserId(): String?
    suspend fun createTheOrder(
        order: Order,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    )
}