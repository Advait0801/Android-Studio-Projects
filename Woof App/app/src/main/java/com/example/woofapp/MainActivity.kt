package com.example.woofapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.woof.data.Dog
import com.example.woof.data.dogs
import com.example.woofapp.ui.theme.WoofTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WoofTheme {
                WoofApp()
            }
        }
    }
}

/**
 * Composable that displays an app bar and a list of dogs.
 */
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun WoofApp() {
    Scaffold(
        topBar = {
            WoofTopAppBar()
        }
    ) {
        LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background)) {
            items(dogs) {
                DogItem(dog = it)
            }
        }
    }
}

@Composable
fun DogItem(dog: Dog, modifier: Modifier = Modifier) {
    Card(
        elevation = 4.dp,
        modifier = modifier.padding(8.dp)
    ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                DogIcon(dog.imageResourceId)
                DogInformation(dog.name, dog.age)
        }
    }
}

@Composable
fun WoofTopAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.primary),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = modifier
                .size(64.dp)
                .padding(8.dp),
            painter = painterResource(R.drawable.ic_woof_logo),
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.h1
        )
    }
}

@Composable
fun DogIcon(@DrawableRes dogIcon: Int, modifier: Modifier = Modifier) {
    Image(
        modifier = modifier
            .size(64.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(50)),
        contentScale = ContentScale.Crop,
        painter = painterResource(dogIcon),
        contentDescription = null
    )
}

@Composable
fun DogInformation(@StringRes dogName: Int, dogAge: Int, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = stringResource(dogName),
            style = MaterialTheme.typography.h2,
            modifier = modifier.padding(top = 8.dp)
        )
        Text(
            text = stringResource(R.string.years_old, dogAge),
            style = MaterialTheme.typography.body1
        )
    }
}


@Preview
@Composable
fun WoofPreview() {
    WoofTheme(darkTheme = false) {
        WoofApp()
    }
}

@Preview
@Composable
fun WoofDarkThemePreview() {
    WoofTheme(darkTheme = true) {
        WoofApp()
    }
}
