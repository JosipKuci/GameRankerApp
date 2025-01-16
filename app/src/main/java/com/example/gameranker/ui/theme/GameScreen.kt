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
import androidx.navigation.NavController
import com.example.gameranker.R
import com.example.gameranker.Routes
import com.example.gameranker.data.Games
import com.example.gameranker.data.iframe

@Composable
fun GameScreen(navigation: NavController, gameId:Int) {
    var current_game=Games[gameId]
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
                Game(
                    gameTitle = current_game.title,
                    rank = current_game.rank,
                    platform = current_game.platform,
                    releaseYear = current_game.releaseYear,
                    imageRes = current_game.imageRes,
                    summary = current_game.summary
                )
            }
        }
    }
}
@Composable
fun Game(gameTitle: String, rank:Int,platform: String, releaseYear: Int, imageRes: Int, summary:String) {
    val color:Long
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
        modifier = Modifier.fillMaxWidth(),
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
            Text(
                text = gameTitle,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier
                    .height(350.dp),
                contentScale = ContentScale.Crop
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
            Text(
                text = "Trailer",
                fontSize = 24.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            AndroidView(factory = {
                WebView(it).apply {
                    this.layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    this.webViewClient = WebViewClient()
                }
            }, update = {
                it.settings.javaScriptEnabled=true
                it.loadData(iframe[rank-1],"text/html","utf-8")
            })

        }
    }}
