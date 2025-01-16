package com.example.gameranker.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gameranker.Routes
import com.example.gameranker.data.UserRanksViewModel
import com.example.gameranker.data.userGames

@Composable
fun AddNewListScreen(navigation:NavController,viewModel: UserRanksViewModel) {

    var newList:userGames= userGames()

    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    MaterialTheme {
        Surface(color = Color(0xFF2C2F33), modifier = Modifier.fillMaxSize()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Add new list",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFFA500) // Orange color
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Title Input Field
        Text(
            text = "Title:",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = text1,
            onValueChange = {text1=it},
            placeholder = { Text("Enter title", color = Color.Gray) },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(8.dp)),
            singleLine = true,
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledContainerColor = Color.White
            )
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Creator Input Field
        Text(
            text = "Creator:",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = text2,
            onValueChange = {text2=it},
            placeholder = { Text("Creator name", color = Color.Gray) },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(8.dp)),
            singleLine = true,
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledContainerColor = Color.White
            )
        )
        Spacer(modifier = Modifier.height(24.dp))

        // Add New List Button
        Button(
            onClick = {newList.Title=text1
                newList.Creator=text2
                viewModel.addList(newList)
                viewModel.fetchData()
                      navigation.navigate(Routes.SCREEN_USER_LISTS)},
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(50.dp)
        ) {
            Text(text = "ADD NEW LIST", color = Color.Black)
        }
    }
        }
    }
}