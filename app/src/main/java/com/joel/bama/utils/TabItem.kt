package com.joel.bama.utils

import androidx.compose.runtime.Composable
import com.joel.bama.presentation.views.PaidScreen
import com.joel.bama.presentation.views.PreparedScreen
import com.joel.bama.presentation.views.TransportScreen

typealias ComposableFun = @Composable () -> Unit


sealed class TabItem(
    val title : String,
    val screen : ComposableFun
){

    object Paid : TabItem(
        title = "PAID",
        screen = { PaidScreen() }
    )

    object Prepared : TabItem(
        title = "PREPARED",
        screen = { PreparedScreen() }
    )

    object Transport : TabItem(
        title = "TRANSPORT",
        screen = { TransportScreen() }
    )

}
