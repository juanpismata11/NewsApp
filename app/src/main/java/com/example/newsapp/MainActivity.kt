package com.example.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.example.newsapp.ui.theme.NewsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

data class Noticias(
    val descripcion: String,
    val fecha: String
)

@Composable
fun HomePage(){
    var textSearchBar by remember { mutableStateOf("") }

    val noticias = listOf(
        Noticias("El presidente de EE. UU. no muestra signos de arrepentimiento... ","febrero 08 - 2025"),
        Noticias("Banarse en la piscina del rio de Cleopatra", "febrero 10 - 2024"),
        Noticias("Gigantes tecnologias de inteligencia artificial hacen algo...", "julio 26 - 2025"),
        Noticias("El rover de marte le hace ping a mi computadora ayuda", "diciembre 20 - 2023")
    )

    Column(){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .padding(10.dp)
        ){
            OutlinedTextField(
                value = textSearchBar,
                onValueChange = { newText ->
                    textSearchBar = newText
                },
                placeholder = {
                    Text(
                        text = "Buscar",
                        fontWeight = FontWeight.Bold
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Search"
                    )
                },
                shape = RoundedCornerShape(28.dp),
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly
        ){
            Text(
                text="Noticias",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )

            Text(
                text="Eventos",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.Gray
            )

            Text(
                text="Clima",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.Gray
            )
        }

        Text(
            text = "Ultimas noticias",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(10.dp)
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ){
            items(noticias){ noticia ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(280.dp)
                        .height(220.dp)
                        .padding(10.dp),

                ){
                    Text(
                        text = noticia.descripcion,
                        modifier = Modifier.fillMaxWidth()
                            .background(Color.Blue)
                            .padding(top = 30.dp)
                            .padding(10.dp),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        maxLines = Int.MAX_VALUE,
                        softWrap = true,
                        overflow = TextOverflow.Ellipsis,

                    )

                    Text(
                        text = noticia.fecha,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxSize()
                            .background(Color.Blue)
                            .padding(10.dp),
                        color = Color.White,

                    )
                }
            }

        }

        Text(
            text = "Alrededor del mundo",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(10.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {
            items(noticias){ news ->

                Column(
                    modifier = Modifier
                ){
                    Card(
                        modifier = Modifier
                            .padding(15.dp)
                            .height(200.dp)

                    ){
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.LightGray)
                                .padding(10.dp),
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = news.descripcion,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                modifier = Modifier
                            )
                        }
                    }
                }



            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsAppTheme {
        HomePage()
    }
}