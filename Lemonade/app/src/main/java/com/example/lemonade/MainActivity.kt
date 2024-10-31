package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Surface {
                    MakeLemonade()

                }
            }
        }
    }
}



@Composable
fun MakeLemonade() {
    var step by remember { mutableStateOf(1) }
    var squeeze by remember { mutableStateOf(0) }

    when (step) {
        1 -> {
            LemonTextAndImage(
                textLabel = R.string.lemon_tree,
                imageResource = R.drawable.lemon_tree,
                contentDescription = R.string.step_1,
                imageClick = {
                    step = 2
                    squeeze = (2..4).random()
                }
            )
        }

        2 -> {
            LemonTextAndImage(
                textLabel = R.string.lemon,
                imageResource = R.drawable.lemon_squeeze,
                contentDescription = R.string.step_2,
                imageClick = {
                    squeeze--
                    if (squeeze == 0) {
                        step = 3
                    }
                }
            )
        }

        3 -> {
            LemonTextAndImage(
                textLabel = R.string.glass,
                imageResource = R.drawable.lemon_drink,
                contentDescription = R.string.step_3,
                imageClick = {
                    step = 4
                }
            )
        }

        4 -> {
            LemonTextAndImage(
                textLabel = R.string.empty_glass,
                imageResource = R.drawable.lemon_restart,
                contentDescription = R.string.step_4,
                imageClick = {
                    step = 1
                }
            )
        }
    }
}

@Composable
fun LemonTextAndImage(
    textLabel: Int,
    imageResource: Int,
    contentDescription: Int,
    imageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            shape = RoundedCornerShape(24.dp),
            onClick = imageClick
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = stringResource(textLabel)
            )
        }
        Text(
            text = stringResource(contentDescription),
            modifier = modifier.padding(top = 12.dp),
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        MakeLemonade()
    }
}