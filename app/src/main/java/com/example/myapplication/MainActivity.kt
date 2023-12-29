package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {


                    Child()
//

                    MainScreen()

                }
            }
        }
    }
}


@Composable
fun Child() {

    // create 2 nested component where the variable define in Parent and we show the value in child. Now we will
    // put one button in parent on clicking of which changes the value of in parent and its show the updated
    // value in child

    val text = remember{ mutableIntStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = text.intValue.toString(),
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 18.sp
        )

        Parent(onClick = { text.intValue++ })

    }


}

@Composable
fun Parent(
    onClick: () -> Unit
) {

    Button(onClick = { onClick() }) {
        Text(text = "Click Me")
    }


}

