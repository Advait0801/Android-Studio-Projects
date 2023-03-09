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
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}
@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Preview
@Composable
fun LemonadeApp(){
    val str = stringResource(id = R.string.lemon)
    val image = painterResource(id = R.drawable.lemon_squeeze)
    LemonadeVisual(textvar = str, image = image)
}
@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun LemonadeVisual(textvar: String,image: Painter){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = textvar,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(painter = image,
            contentDescription = null,
            Modifier.border(3.dp, color = Color(105,205,216))
        )
    }
}
