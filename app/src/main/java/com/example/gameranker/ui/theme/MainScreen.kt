package com.example.gameranker.ui.theme

import android.webkit.WebView
import android.widget.ScrollView
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gameranker.R
import com.example.gameranker.Routes
import com.example.gameranker.data.Games
import com.example.gameranker.data.game

@Composable
fun MainScreen(navigation:NavController) {
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
                for(item in Games)
                {
                    Spacer(modifier = Modifier.height(16.dp))
                    GameCard(
                        gameTitle = item.title,
                        rank=item.rank,
                        platform = item.platform,
                        releaseYear = item.releaseYear,
                        imageRes = item.imageRes // Replace with your drawable resource
                    )
                    {
                        navigation.navigate(Routes.getGameDetailsPath(item.rank-1))
                    }
                }

            }
        }
    }
}

@Composable
fun Header(navigation:NavController) {
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = "Game Ranker",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFFFA500)
    )
    Spacer(modifier = Modifier.height(8.dp))
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxWidth()
    ) {
        TabItem(text = "Main page",navigation)
        TabItem(text = "Your pick",navigation)
        TabItem(text = "About",navigation)
    }
}

@Composable
fun TabItem(text: String,navigation:NavController) {
    Button(
        onClick = { if(text=="Main page"){navigation.navigate(Routes.SCREEN_ALL_GAMES) }
            else if(text=="Your pick"){
                navigation.navigate(Routes.SCREEN_USER_LISTS)
            }
            else{
                navigation.navigate(Routes.SCREEN_ABOUT)
            }
                  },
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        modifier = Modifier.padding(horizontal = 5.dp)
    ) {
        Text(text = text, color = Color.Black)
    }
}

@Composable
fun GameCard(gameTitle: String, rank:Int, platform: String, releaseYear: Int, imageRes: Int, onClick: () -> Unit) {
    var color:Long
    when (rank) {
        1 -> color=0xffffff8d
        2 -> color=0xff9e9e9e
        3 -> color=0xff8d6e63
        else -> { // Note the block
            color=0xFFD6D6D6
        }
    }
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth()
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = Color(color)),

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
                painter = painterResource(id = imageRes),
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