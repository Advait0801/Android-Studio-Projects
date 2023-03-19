package com.example.coursesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coursesapp.model.Topic
import com.example.coursesapp.ui.theme.CoursesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesAppTheme {
                CourseApp()
            }
        }
    }
}

@Composable
fun CourseApp(modifier: Modifier = Modifier){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2) ,
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(DataSource.topics){
            it -> CourseAppCard(topic = it)
        }
    }
}

@Composable
fun CourseAppCard(topic: Topic, modifier: Modifier = Modifier){
    Card(elevation = 4.dp) {
        Row {
            Image(
                painter = painterResource(id = topic.courseImageId),
                contentDescription = null,
                modifier = modifier
                    .size(height = 68.dp, width = 68.dp)
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop
            )

            Column {
                Text(
                    text = stringResource(id = topic.courseNameId),
                    modifier = modifier
                        .padding(top = 16.dp, end = 16.dp, bottom = 8.dp, start = 14.dp),
                    style = MaterialTheme.typography.body2
                )

                Row (verticalAlignment = Alignment.CenterVertically){
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = modifier.padding(start = 14.dp)
                    )
                    
                    Text(
                        text = topic.courseNumber.toString(),
                        modifier = modifier.padding(start = 8.dp),
                        style = MaterialTheme.typography.caption
                    )
                }
            }
        }
    }
}
