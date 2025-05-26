package org.goiaba.boots.shop.data.domain

import kotlinx.coroutines.flow.Flow
import org.goiaba.boots.shop.shared.domain.Product
import org.goiaba.boots.shop.shared.domain.ProductCategory
import org.goiaba.boots.shop.shared.utils.RequestState

interface ProductRepository {
    fun getCurrentUserId(): String?
    fun readDiscountedProducts(): Flow<RequestState<List<Product>>>
    fun readNewProducts(): Flow<RequestState<List<Product>>>
    fun readProductByIdFlow(id: String): Flow<RequestState<Product>>
    fun readProductsByIdsFlow(ids: List<String>): Flow<RequestState<List<Product>>>
    fun readProductsByCategoryFlow(category: ProductCategory): Flow<RequestState<List<Product>>>
}