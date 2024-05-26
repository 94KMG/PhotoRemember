package com.example.photoremember

import android.os.Bundle
import android.text.Layout.Alignment
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.photoremember.ui.theme.PhotoRememberTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotoRememberTheme {
                // A surface container using the 'background' color from the theme
                MainScreen()
            }
        }
    }
}


@Composable
fun MainScreen(modifier: Modifier= Modifier){
    var imageResouce by remember {
        mutableStateOf(R.drawable.entj)
    }

    var blur by remember {
        mutableStateOf(modifier)
    }

    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Image(modifier = blur,
            painter = painterResource(id = imageResouce),
            contentDescription = "null")
        Button(onClick = {
            when(imageResouce) {
                R.drawable.entj -> imageResouce = R.drawable.infp
                R.drawable.infp -> imageResouce = R.drawable.intj
                R.drawable.intj -> imageResouce = R.drawable.istp
                R.drawable.istp -> imageResouce = R.drawable.entj

            }
        }) {
            Text(
                text = "변경",
                textAlign = TextAlign.Center)
        }
        Button(onClick = {
            if(blur==modifier){
                blur = modifier.blur(radiusX =10.dp, radiusY = 10.dp)

            }else{
                blur=modifier
            }
        }) {
            Text(text = "블러")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PhotoRememberTheme {
        MainScreen()
    }
}