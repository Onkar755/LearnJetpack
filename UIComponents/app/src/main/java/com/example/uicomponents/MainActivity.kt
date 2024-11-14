package com.example.uicomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uicomponents.CustomComponents.GoogleButton
import com.example.uicomponents.ui.theme.UIComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UIComponentsTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    GoogleButton(
                        text = "Sign Up with Facebook",
                        loadingText = "Signing Up....",
                        onClicked = {}
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UIComponentsTheme {

    }
}

/* Super/Sub Script Text */
@Composable
fun SuperScriptText(
    normalText: String,
    superText: String
) {
    Text(buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = MaterialTheme.typography.headlineLarge.fontSize
            )
        ) {
            append(normalText)
        }
        withStyle(
            style = SpanStyle(
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                fontWeight = FontWeight.Normal,
                baselineShift = BaselineShift.Superscript
            )
        ) {
            append(superText)
        }
    })
}

/* Text Selection */
@Composable
fun CustomText() {
    SelectionContainer {
        Column {
            Text(
                text = "Hello Android!"
            )
            DisableSelection {
                Text(
                    text = "Hello Android!"
                )
            }
            Text(
                text = "Hello Android!"
            )
        }
    }
}


/* Box */
@Composable
fun Boxes() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Box(
            modifier = Modifier
                .background(Color.Red),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .background(Color.Yellow)
            )
            Text(
                text = "Hello World! Android",
                fontSize = 40.sp
            )
        }
    }
}
