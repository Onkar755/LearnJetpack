package com.example.u1pr1composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.u1pr1composearticle.ui.theme.U1PR1ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            U1PR1ComposeArticleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ShowArticle(
                        title = stringResource(R.string.title),
                        text1 = stringResource(R.string.text1),
                        text2 = stringResource(R.string.text2),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ShowArticle(title: String, text1: String, text2: String, modifier: Modifier = Modifier) {
    val painter = painterResource(R.drawable.bg_compose_background)
    Column(modifier = modifier) {
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = text1,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = text2,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    U1PR1ComposeArticleTheme {
        ShowArticle(
            stringResource(R.string.title),
            stringResource(R.string.text1),
            stringResource(R.string.text2)
        )
    }
}