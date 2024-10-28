package com.example.u1pr3composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.u1pr3composequadrant.ui.theme.U1PR3ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            U1PR3ComposeQuadrantTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeQuadrant()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrant() {
    Column(
        Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.weight(1f)
        ) {
            Card(
                stringResource(R.string.title_composable),
                stringResource(R.string.text_composable),
                color = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            Card(
                stringResource(R.string.title_image),
                stringResource(R.string.text_image),
                color = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            modifier = Modifier.weight(1f)
        ) {
            Card(
                stringResource(R.string.title_row),
                stringResource(R.string.text_row),
                color = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            Card(
                stringResource(R.string.title_column),
                stringResource(R.string.text_column),
                color = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun Card(title: String, text: String, color: Color, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = text,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    U1PR3ComposeQuadrantTheme {
        ComposeQuadrant()
    }
}