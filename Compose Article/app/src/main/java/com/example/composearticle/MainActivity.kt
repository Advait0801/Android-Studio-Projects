package com.example.composearticle

import android.media.Image
import android.os.Bundle
import android.view.Display
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArticleCompose()
                }
            }
        }
    }
}

@Composable
fun ArticleCompose(){
    Display(
        title = stringResource(id = R.string.title),
        str1 = stringResource(id = R.string.description_1),
        str2 = stringResource(id = R.string.description_2)
    )
}

@Composable
fun Display(title: String,
            str1: String,
            str2: String
){
    val image = painterResource(id = R.drawable.bg_compose_background)
    Column (){
        Image(painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(text = str1,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 16.dp , end = 16.dp)
        )
        Text(text = str2,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeArticleTheme {
        ArticleCompose()
    }
}