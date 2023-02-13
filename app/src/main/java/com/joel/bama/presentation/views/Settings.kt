package com.joel.bama.presentation.views

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joel.bama.R

@Composable
fun Settings(){

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "\uD83E\uDD69",
                fontSize = 132.sp
            )
        }


        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                          Toast.makeText(context, "Signing in.....", Toast.LENGTH_LONG).show()
                },
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(15.dp),
            ) {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(text = "SignIn")
                    Icon(painter = painterResource(id = R.drawable.ic_baseline_person), contentDescription = null)
                }
            }
            Button(
                onClick = {
                    Toast.makeText(context, "Creating new Account", Toast.LENGTH_LONG).show()
                },
                modifier = Modifier
                    .padding(22.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(15.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(text = "Create Account")
                    Icon(painter = painterResource(id = R.drawable.ic_baseline_person_add), contentDescription = null)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsPreview(){
    Settings()
}