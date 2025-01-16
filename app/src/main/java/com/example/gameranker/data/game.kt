package com.example.gameranker.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.gameranker.R

data class game(
    val rank:Int=999,
    var title:String="",
    var platform:String="",
    var releaseYear:Int=0,
    var imageRes:Int=0,
    var summary:String=""
)
data class userGame(
    val rank:Int=999,
    var Title:String="",
    var Platforms:String="",
    var YearReleased:Int=0,
    var Image:String="",
    var Summary:String=""
)
data class userGames(
    var id:String="",
    var Creator:String="",
    var Games:MutableList<userGame> = mutableListOf(),
    var Title:String=""
)
val Games:List<game> = listOf(
    game(1,
        "Legend of Zelda: Ocarina of Time",
        "Nintendo 64",
        1996,
        R.drawable.loz_oot,
        "A young Hylian boy Link, must defend Hyrule and the Triforce from the Gerudo King Ganondorf. Through the power of the Ocarina of Time, Link travels back and forth through time to set things right again. Basically a prequel to all Zelda games, it shows Link's original life and trials before all other Zelda games."
    ),
    game(2,
        "SoulCalibur",
        "Sega Dreamcast",
        1999,
        R.drawable.soulcalibur,
        "The mystical sword of the legends, the \"Soul Edge\", ended up in the hands of the dreaded pirate Cervantes de Leon of Spain. Play as one of the 19 characters on a mission to acquire the Soul Edge."
    ),
    game(3,
        "Grand Theft Auto IV",
        "PS3 | Xbox360 | PC",
        2008,
        R.drawable.gta4,
        "Niko Bellic, a south eastern European and previous soldier migrates to America to forget all the memories from the war in his country. He comes to Liberty City to join his cousin. He comes to Liberty City to live the American Dream his cousin told him so much about. However this dream ain't true. And instead of living like a boss both of them gets thrown in to a dark underworld were they're forced to work for the mob."
    ),
    game(4,
        "Super Mario Galaxy",
        "Nintendo Wii",
        2007,
        R.drawable.supermariogalaxy,
        "Bowser kidnaps Princess Peach and takes her to the center of the universe where he is creating his own galaxy to control the whole universe. It is up to Mario, Luigi and new friends to travel galaxy after galaxy until they find her."
    ),
    game(5,
        "Super Mario Galaxy 2",
        "Nintendo Wii",
        2010,
        R.drawable.nintendo_super_mario_galaxy_2,
        "In Mushroom Kingdom, Princess Peach holds a celebration for it's anniversary in it's kingdom and Mario is invited, but then it gets interrupted by it's evil bowser who is here to make a devastated place in space. Then it's up to Mario to pursue Bowser, with help by his friend Luma and meet a loyal-companion Lubba who helps out Mario save Princess Peach from Bowser from destroying the whole entire galaxy of the Luma's."
    ),
    game(6,
        "The Legend of Zelda: Breath of the Wild",
        "Nintendo Wii U | Switch",
        2017,
        R.drawable.the_legend_of_zelda_breath_of_the_wild_sunset,
        "After a century of hibernation, Link reawakens to once again save a ruined Hyrule from a great evil. 100 years before the main events of the game, the Calamity Ganon returned, controlled the Guardiens and indirectly killed the legendary four Champions as well the King of Hyrule."
    ),
    game(7,
        "Tony Hawk's Pro Skater 3",
        "PS2 | GameCube | Xbox | PS | PC | GBA",
        2001,
        R.drawable.tonyhawksproskater3,
        "Get more air, pull off more insane tricks and unlock new characters and levels in Tony Hawk's Pro Skater 3."
    ),
    game(8,
        "Perfect Dark",
        "Nintendo 64",
        2000,
        R.drawable.perfectdark,
        "A female spy named Joanna Dark who received the highest grade ever from her spy training at Carrington Institute is sent to rescue a Doctor Caroll who sent a distress call to Carrington a few days before."
    ),
    game(9,
        "Red Dead Redemption 2",
        "PC | Xbox One | PS4",
        2018,
        R.drawable.red_dead_redemption_2_cover,
        "Amidst the decline of the Wild West at the turn of the 20th century, outlaw Arthur Morgan and his gang struggle to cope with the loss of their way of life."
    ),
    game(10,
        "Grand Theft Auto V",
        "PC | PS3 | Xbox 360 | Xbox One | PS4 | PS5 | Xbox Series X",
        2013,
        R.drawable.gta5,
        "When a young street hustler, a retired bank robber, and a terrifying psychopath find themselves entangled with some of the most frightening and deranged elements of the criminal underworld, the U.S. Government, and the entertainment industry, they must pull off a series of dangerous heists to survive in a ruthless city"
    ),


)
val iframe:List<String> = listOf(
    "<iframe width=\"100%\" height=\"250px\" src=\"https://www.youtube.com/embed/_NElFLzgdUs\" title=\"Legend of Zelda Ocarina of Time Trailer - 720p HD Quality\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>",
    "<iframe width=\"100%\" height=\"250px\" src=\"https://www.youtube.com/embed/Dqn22WCOySI\" title=\"Soul Blade Trailer\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>",
    "<iframe width=\"100%\" height=\"250px\" src=\"https://www.youtube.com/embed/M80K51DosFo\" title=\"Grand Theft Auto IV Trailer 1 &quot;Things Will Be Different&quot;\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>",
    "<iframe width=\"100%\" height=\"250px\" src=\"https://www.youtube.com/embed/rmN8DHZYNCg\" title=\"Super Mario Galaxy Nintendo Wii Trailer - GDC 2007 Trailer\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>",
    "<iframe width=\"100%\" height=\"250px\" src=\"https://www.youtube.com/embed/9yTZcpAx1ik\" title=\"Super Mario Galaxy 2 Trailer\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>",
    "<iframe width=\"100%\" height=\"250px\" src=\"https://www.youtube.com/embed/1rPxiXXxftE\" title=\"The Legend of Zelda: Breath of the Wild - Official Game Trailer - Nintendo E3 2016\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>",
    "<iframe width=\"100%\" height=\"250px\" src=\"https://www.youtube.com/embed/daEAZ40LdC8\" title=\"Tony Hawk&#39;s Pro Skater 3 - 2001 Beta Trailer [High Quality]\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>",
    "<iframe width=\"100%\" height=\"250px\" src=\"https://www.youtube.com/embed/ZZMph4U0w3o\" title=\"Perfect Dark Trailer (Original)\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>",
    "<iframe width=\"100%\" height=\"250px\" src=\"https://www.youtube.com/embed/gmA6MrX81z4\" title=\"Red Dead Redemption 2 Trailer\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>",
    "<iframe width=\"100%\" height=\"250px\" src=\"https://www.youtube.com/embed/QkkoHAzjnUs\" title=\"Grand Theft Auto V Trailer\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>"
)

var NewGameListId:String =""