package com.joel.bama.presentation.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joel.bama.R
import com.joel.bama.core.ui.theme.BamaTheme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun EditScreen(
    navigator: DestinationsNavigator
){

    var item by remember {
        mutableStateOf("")
    }

    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
                 TopAppBar(
                     title = {
                         Text(text = "Add Item")
                     },
                     navigationIcon = {
                         IconButton(onClick = {
                             navigator.popBackStack()
                         }) {
                             Icon(painter = painterResource(id = R.drawable.ic_baseline_arrow_back), contentDescription = "")
                         }
                     }
                 )
        },

        
    ) {

        Column(
            modifier = Modifier
                .verticalScroll(state = scrollState)
                .padding(2.dp)
        ) {

            OutlinedTextField(
                value = item,
                onValueChange = {
                    item = it
                },
                placeholder = {
                    Text(text = "Item")
                },
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(15.dp),
                )
            OutlinedTextField(
                value = item,
                onValueChange = {
                    item = it
                },
                placeholder = {
                    Text(text = "Description")
                },
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
                    .height(150.dp)
            )
            Text(
                text = "Item Labels",
                modifier = Modifier
                    .padding(8.dp),
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold
            )

            Card(
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth(),
                elevation = 4.dp
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(22.dp)
                ) {
                    Text(text = "No Selected Labels")
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_edit_24),
                        contentDescription = "edit_button",

                    )
                }
            }

            Text(
                text = "Was Ordered At",
                modifier = Modifier
                    .padding(12.dp),
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(12.dp)
            ) {
                Card(
                    modifier = Modifier
                        .width(150.dp)
                        .scale(1.5f)
                        .padding(12.dp)
                        .clickable {

                        },

                    shape = RoundedCornerShape(15.dp),
                    elevation = 4.dp
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(10.dp)

                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_calendar_today_24),
                            contentDescription = "")
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "Date")
                    }
                }
                Spacer(modifier = Modifier.width(50.dp))
                Card(
                    modifier = Modifier
                        .width(150.dp)
                        .scale(1.5f)
                        .padding(12.dp)
                        .clickable {

                        },
                    shape = RoundedCornerShape(15.dp),
                    elevation = 4.dp
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .padding(10.dp)

                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_access_time_24),
                            contentDescription = "")
                        Text(text = "Time")
                    }
                }
            }
            
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.scale(1.2f)

                ) {
                    Text(
                        text = "Item State",
                        modifier = Modifier
                            .padding(12.dp),
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Card(
                        modifier = Modifier
                            .clickable {

                            }
                            .padding(12.dp),
                        shape = RoundedCornerShape(15.dp),
                        elevation = 5.dp
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.padding(18.dp)
                        ) {
                            Text(text = "PAID")
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_down_24),
                                contentDescription = "")
                        }
                    }
                }
                Spacer(modifier = Modifier.width(80.dp))

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.scale(1.0f)
                ) {
                    Text(
                        text = "No of kgs ",
                        modifier = Modifier
                            .padding(12.dp),
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold
                    )
                    OutlinedTextField(
                        value = item,
                        onValueChange = {
                            item = it
                        },
                        modifier = Modifier.width(100.dp)
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(id = R.drawable.ic_baseline_delete_24), contentDescription = "discard")
                    Text(text = "Discard")
                }
                Button(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(id = R.drawable.ic_baseline_save_24), contentDescription = "discard")
                    Text(text = "Save")
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun EditPreview(){
//    BamaTheme {
//        EditScreen()
//    }
//}
