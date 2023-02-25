package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthdayImage("Happy Birthday Advait!", "from Advait")
                }
            }
        }
    }
}

@Composable
fun BirthdayGreeting(message: String,from: String){
    Column {
        Text(
            text = message,
            fontSize = 34.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.Start)
                .padding(start = 16.dp, top = 16.dp),
        )
        Text(text = from ,
            fontSize = 20.sp,
            modifier = Modifier.fillMaxWidth()
            .wrapContentWidth(align = Alignment.End)
            .padding(start = 16.dp , end = 16.dp)
        )
    }
}

@Composable
fun BirthdayImage(message: String,from: String){
    val image = painterResource(id = R.drawable.androidparty)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = Crop
        )
        BirthdayGreeting(message = message , from = from)
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayImagePreview() {
    HappyBirthdayTheme {
        BirthdayImage(stringResource(R.string.happy_text),"from Advait")
    }
}