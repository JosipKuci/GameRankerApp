package com.example.gameranker.ui.theme
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ScrollView
import androidx.compose.foundation.Image
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
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.gameranker.R
import com.example.gameranker.Routes
import com.example.gameranker.data.Games
import com.example.gameranker.data.UserRanksViewModel
import com.example.gameranker.data.iframe
import com.example.gameranker.data.userGame

@Composable
fun UserGameScreen(navigation: NavController, gameRank:Int, viewModel: UserRanksViewModel, Id:String) {
    var current_game:userGame= userGame()
    for(lists in viewModel.rankingsData)
    {
        if(lists.id==Id)
        {
            for(game in lists.Games)
            {
                if(game.rank==gameRank)
                {
                    current_game=game
                }
            }
        }
    }
    MaterialTheme {
        Surface(color = Color(0xFF2C2F33), modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Header(navigation)
                Spacer(modifier = Modifier.height(16.dp))
                UserGame(
                    gameTitle = current_game.Title,
                    rank = current_game.rank,
                    platform = current_game.Platforms,
                    releaseYear = current_game.YearReleased,
                    image = current_game.Image,
                    summary = current_game.Summary
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        viewModel.rankingsData.find { it.id==Id }?.Games?.remove(current_game)
                        navigation.navigate(Routes.SCREEN_USER_LISTS)},
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .height(50.dp)
                ) {
                    Text(text = "DELETE GAME", color = Color.White)
                }
            }
        }
    }
}
@Composable
fun UserGame(gameTitle: String, rank:Int,platform: String, releaseYear: Int, image:String, summary:String) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFD6D6D6)),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "#$rank",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = gameTitle,
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

            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Platform: $platform",
                fontSize = 14.sp,
                color = Color.Black
            )
            Text(
                text = "Released: $releaseYear",
                fontSize = 14.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Summary",
                fontSize = 24.sp,
                color = Color.Black
            )
            Text(
                text = summary,
                fontSize = 14.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(4.dp))
        }
    }}
