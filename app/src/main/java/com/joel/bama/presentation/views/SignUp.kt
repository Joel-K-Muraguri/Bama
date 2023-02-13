package com.joel.bama.presentation.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joel.bama.presentation.views.destinations.LoginDestination
import com.joel.bama.presentation.views.destinations.ProfileScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun SignUp(
    navigator: DestinationsNavigator
){

    var email by remember {
        mutableStateOf("")
    }
    var newPassword by remember {
        mutableStateOf("")
    }
    var confirmPassword by remember {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Create Account")
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
                value =  newPassword,
                onValueChange = {
                    newPassword = it
                },
                placeholder = {
                    Text(text = "New Password")
                },
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            )
            OutlinedTextField(
                value =  confirmPassword,
                onValueChange = {
                    confirmPassword = it
                },
                placeholder = {
                    Text(text = "Confirm Password")
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
                Text(text = "Create Account")
            }

            TextButton(
                onClick = {
                          navigator.navigate(LoginDestination)
                },
            ) {
                Column(
                    modifier = Modifier
                        .padding(6.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Already have an account?")
                    Text(text = "Click here to Sign in")
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun SignUpPreview(){
//    SignUp()
//}