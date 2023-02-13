package com.joel.bama.presentation.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joel.bama.presentation.components.Avatar
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Destination
@Composable
fun ProfileScreen(
//    viewModel: AuthViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
){
//    viewModel.currentUser?.let {
//        UserInfo(viewModel = viewModel, navigator = navigator, name = it.displayName.toString(), email = it.email.toString())
//    }
    UserInfo(navigator)

}

@Composable
fun UserInfo(
    navigator: DestinationsNavigator
) {

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {
                        navigator.popBackStack()
                    }) {
                        Icon(
                            painter = painterResource(id = com.joel.bama.R.drawable.ic_baseline_arrow_back),
                            contentDescription = "")
                    }

                },
                title = {
                    Text(text = "User Profile")
                }
            )
        },

        )
    {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
        ) {

            Text(
                text = "Hi Joel",
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(12.dp)
            )
            Avatar()
            Text(
                text = "Welcome BACK",
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(12.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {

                Text(
                    text = "NAME :",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier
                        .padding(12.dp)
                )
                Text(
                    text = "Joel",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier
                        .padding(12.dp)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Text(
                    text = "EMAIL :",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier
                        .padding(12.dp)
                )
                Text(
                    text = "@gmail.com",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier
                        .padding(12.dp)
                )
            }


            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(32.dp)
            ) {
                Button(onClick = {
//                    viewModel.logout()
//                    navigator.navigate(LogInScreenDestination){
//                        popUpTo(ListScreenDestination){
//                            inclusive = true
//                        }
//                    }
                },
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .fillMaxWidth(2f)
                ) {
                    Text(text = "Logout")
                }

            }
        }
    }
}