package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    WholeDisplay()
                }
            }
        }
    }
}

@Composable
fun WholeDisplay(){
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.weight(1f)) {
            QuadrantDisplay(
                text1 = stringResource(id = R.string.title_1),
                text2 = stringResource(id = R.string.description_1),
                bgcolor = Color.Green,
                modifier = Modifier.weight(1f)
            )
            QuadrantDisplay(
                text1 = stringResource(id = R.string.title_2),
                text2 = stringResource(id = R.string.description_2),
                bgcolor = Color.Yellow,
                modifier = Modifier.weight(1f)
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            QuadrantDisplay(
                text1 = stringResource(id = R.string.title_3),
                text2 = stringResource(id = R.string.description_3),
                bgcolor = Color.Cyan,
                modifier = Modifier.weight(1f)
            )
            QuadrantDisplay(
                text1 = stringResource(id = R.string.title_4),
                text2 = stringResource(id = R.string.description_4),
                bgcolor = Color.LightGray,
                modifier = Modifier.weight(1f)
            )
        }
    }

}

@Composable
fun QuadrantDisplay(
    text1: String,
    text2: String,
    bgcolor: Color,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier
        .fillMaxSize()
        .background(bgcolor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = text1,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = text2,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(12.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeQuadrantTheme {
        WholeDisplay()
    }
}