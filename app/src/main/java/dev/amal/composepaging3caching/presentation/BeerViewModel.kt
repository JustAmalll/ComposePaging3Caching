package dev.amal.composepaging3caching.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.amal.composepaging3caching.data.local.BeerEntity
import dev.amal.composepaging3caching.data.mappers.toBeer
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class BeerViewModel @Inject constructor(
    pager: Pager<Int, BeerEntity>
) : ViewModel() {

    val beerPagingFlow = pager
        .flow
        .map { pagingData -> pagingData.map { it.toBeer() } }
        .cachedIn(viewModelScope)
}