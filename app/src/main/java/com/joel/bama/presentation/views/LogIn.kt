package com.joel.bama.presentation.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joel.bama.presentation.views.destinations.ProfileScreenDestination
import com.joel.bama.presentation.views.destinations.SignUpDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun Login(
    navigator: DestinationsNavigator
){
    
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Sign In")
                }
            )
        }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            OutlinedTextField(
                value =  email,
                onValueChange = {
                                email = it
                },
                placeholder = {
                    Text(text = "Email")
                },
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            )
            OutlinedTextField(
                value =  password,
                onValueChange = {
                    password = it
                },
                placeholder = {
                    Text(text = "Password")
                },
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            )
            Button(
                onClick = {
                          navigator.navigate(ProfileScreenDestination)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Text(text = "Sign In")
            }

            TextButton(
                onClick = {
                          navigator.navigate(SignUpDestination)
                },
            ) {
                Column(
                    modifier = Modifier
                        .padding(6.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Don't have an account?")
                    Text(text = "Click here to Create Account")
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun LoginPreview(){
//    Login()
//}