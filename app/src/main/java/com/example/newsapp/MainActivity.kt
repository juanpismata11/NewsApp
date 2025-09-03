package com.example.newsapp

import android.R.attr.fontWeight
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.ui.theme.NewsAppTheme
import org.intellij.lang.annotations.JdkConstants

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

@Composable
fun HomePage(){

    Column(){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .padding(10.dp)
        ){
            OutlinedTextField(
                value = "",
                onValueChange = {

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

    }




}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsAppTheme {
        HomePage()
    }
}