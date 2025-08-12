package com.example.newjetpackcomposecourse.`15_PullToRefresh`

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults
import androidx.compose.material3.pulltorefresh.PullToRefreshState
import androidx.compose.material3.pulltorefresh.pullToRefreshIndicator
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun PullToRefresh() {

    val scope = rememberCoroutineScope()
    var isRefreshing by remember {
        mutableStateOf(false)
    }

    var items by remember {
        mutableStateOf(List(20) { "item $it" })
    }

    fun refreshItems() {

        scope.launch {
            isRefreshing = true
            delay(2000)
            items = List(20) { "items #${(0..100).random()}" }  // simulate data change
            isRefreshing = false
        }
    }


    PulltoRefreshCustomIndicatorSample(
        items = items,
        isRefreshing = isRefreshing,
        onRefresh = { refreshItems() }
    )

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PulltoRefreshCustomIndicatorSample(

    items: List<String>,
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier

) {

    val state = rememberPullToRefreshState()
    PullToRefreshBox(
        isRefreshing = isRefreshing,
        onRefresh = onRefresh,
        state = state,
        modifier = modifier.fillMaxSize(),
        indicator = {
            MyCustomIndicator(

                state = state,
                isRefreshing = isRefreshing,

                )
        }

    ) {

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            items(items) {
                ListItem({ Text(text = it) })
            }
        }

    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCustomIndicator(
    state: PullToRefreshState,
    isRefreshing: Boolean,
    modifier: Modifier = Modifier
) {


    Box(
        modifier = Modifier.pullToRefreshIndicator(
            state = state,
            isRefreshing = isRefreshing,
            containerColor = PullToRefreshDefaults.containerColor,
            threshold = PullToRefreshDefaults.PositionalThreshold
        ),
        contentAlignment = Alignment.Center
    ) {

        Crossfade(
            targetState = isRefreshing,
            animationSpec = tween(1000),
            modifier = Modifier.align(Alignment.Center)
        ) { refreshing ->

            if (refreshing) {
                CircularProgressIndicator(Modifier.size(20.dp))
            } else {


            }

        }

    }

}


@Preview(showSystemUi = true)
@Composable
fun PullToRefreshPreview() {
    PullToRefresh()
}


//  7:43:10  min 