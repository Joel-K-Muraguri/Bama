package com.joel.bama.presentation.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import com.joel.bama.R
import com.joel.bama.presentation.views.destinations.EditScreenDestination
import com.joel.bama.presentation.views.destinations.ProfileScreenDestination
import com.joel.bama.utils.TabItem
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.launch

@Destination(start = true)
@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator
){

    val pagerState = rememberPagerState()
    val tabs = listOf(
        TabItem.Paid,
        TabItem.Prepared,
        TabItem.Transport
    )
    Scaffold(
        topBar = {
            TopSection(navigator)
        },
        floatingActionButton = {
            AddFAB(navigator)

        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Tabs(tabs = tabs, pagerState = pagerState)
            Spacer(modifier = Modifier.height(8.dp))
            TabsContent(tabs = tabs, pagerState = pagerState)
        }
    }
}

@Composable
fun TopSection(navigator: DestinationsNavigator){
    TopAppBar(
        title = {

        },
        actions = {
            IconButton(onClick = {
                navigator.navigate(ProfileScreenDestination)
            }) {
                Icon(painter = painterResource(id = R.drawable.ic_baseline_person), contentDescription = "")
            }
        }
    )
}


@Composable
fun AddFAB(
    navigator: DestinationsNavigator
){
    FloatingActionButton(
        onClick = {
                  navigator.navigate(EditScreenDestination)
        },
        shape = RoundedCornerShape(15.dp)
        
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(18.dp)
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_baseline_add_24), contentDescription = "")
            Text(text = "Add Item")
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(
    tabs : List<TabItem>,
    pagerState: PagerState

){
    val scope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        },
    ) {
        tabs.forEachIndexed { index, tabItem ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = {
                    Text(
                        text = tabItem.title,
                        color = MaterialTheme.colors.onBackground
                    )
                }
            )
        }
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsContent(
    tabs : List<TabItem>,
    pagerState: PagerState
){
    HorizontalPager(count = tabs.size, state = pagerState) { page ->
        tabs[page].screen()
    }

}