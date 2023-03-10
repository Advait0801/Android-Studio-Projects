package com.example.lemonade

import android.icu.text.ListFormatter
import android.icu.text.ListFormatter.Width.SHORT
import android.media.Image
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}


@Preview
@Composable
fun LemonadeApp(){
    var current_ui by remember { mutableStateOf(1) }
    var squeeze_count by remember { mutableStateOf(0) }

    when(current_ui){
        1 -> {
            LemonadeVisual(
                textvar = stringResource(id = R.string.lemon_tree),
                image = painterResource(id = R.drawable.lemon_tree),
                onImageClick = {
                    current_ui = 2
                    squeeze_count = (3..6).random()
                }
            )
        }

        2 -> {
            LemonadeVisual(
                textvar = stringResource(id = R.string.lemon),
                image = painterResource(id = R.drawable.lemon_squeeze),
                onImageClick = {
                    squeeze_count--
                    if (squeeze_count == 0){
                        current_ui = 3
                    }
                }
            )
        }

        3 -> {
            LemonadeVisual(
                textvar = stringResource(id = R.string.lemonade_glass),
                image = painterResource(id = R.drawable.lemon_drink),
                onImageClick = {
                    current_ui = 4
                }
            )
        }

        4 -> {
            LemonadeVisual(
                textvar = stringResource(id = R.string.empty_glass),
                image = painterResource(id = R.drawable.lemon_restart),
                onImageClick = {
                    current_ui = 1
                }
            )
        }
    }
}


@Composable
fun LemonadeVisual(textvar: String,image: Painter,onImageClick: () -> Unit){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = textvar,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = image,
            contentDescription = null,
            Modifier
                .wrapContentSize()
                .clip(RoundedCornerShape(10))
                .clickable(onClick = onImageClick)
                .border(3.dp, color = Color(105, 205, 216), RoundedCornerShape(10))
                .padding(16.dp)
        )
    }
}


