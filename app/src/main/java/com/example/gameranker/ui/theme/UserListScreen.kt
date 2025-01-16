package com.example.gameranker.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.gameranker.Routes
import com.example.gameranker.data.Games
import com.example.gameranker.data.NewGameListId
import com.example.gameranker.data.UserRanksViewModel

@Composable
fun UserListScreen(navigation: NavController, viewModel: UserRanksViewModel, Id:String) {
    var query by remember { mutableStateOf("") }
    MaterialTheme {
        Surface(color = Color(0xFF2C2F33), modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Header(navigation=navigation)
                TextField(
                    value = query,
                    shape = RoundedCornerShape(12.dp),
                    onValueChange = { query = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    label = { Text("Search by name or platform") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {

                        }
                    )
                )
                for(item in viewModel.rankingsData)
                {
                    if(item.id ==Id)
                    {
                        for(user_game in item.Games)
                        {
                            if(user_game.Title.contains(query,ignoreCase = true)
                                || user_game.Platforms.contains(query,ignoreCase = true)) {
                                Spacer(modifier = Modifier.height(16.dp))
                                UserGameCard(
                                    gameTitle = user_game.Title,
                                    rank = user_game.rank,
                                    platform = user_game.Platforms,
                                    releaseYear = user_game.YearReleased,
                                    image = user_game.Image
                                )
                                {
                                    navigation.navigate(
                                        Routes.getUserGameDetailsPath(
                                            item.id,
                                            user_game.rank
                                        )
                                    )
                                }
                            }
                        }
                    }


                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        NewGameListId=Id
                        navigation.navigate(Routes.SCREEN_NEW_GAME)},
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .height(50.dp)
                ) {
                    Text(text = "ADD NEW GAME", color = Color.Black)
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        viewModel.rankingsData.remove(viewModel.rankingsData.find { it.id==Id })
                        navigation.navigate(Routes.SCREEN_USER_LISTS)},
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .height(50.dp)
                ) {
                    Text(text = "DELETE LIST", color = Color.White)
                }


            }
        }
    }
}
@Composable
fun UserGameCard(gameTitle: String, rank:Int, platform: String, releaseYear: Int, image:String,onClick: () -> Unit) {

    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth()
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = Color(0xFFD6D6D6)),

        ) {

        Column(
            modifier = Modifier.padding(16.dp).align(Alignment.CenterHorizontally),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "#$rank",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
           Image(
                painter = rememberAsyncImagePainter(image),
                contentDescription = null,
                modifier = Modifier
                    .height(350.dp),
                contentScale = ContentScale.Crop,

                )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = gameTitle,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Platform: $platform",
                fontSize = 14.sp,
                color = Color.DarkGray
            )
            Text(
                text = "Released: $releaseYear",
                fontSize = 14.sp,
                color = Color.DarkGray
            )


        }
    }
}