package com.example.littlejoy

import android.os.Bundle
import android.view.Gravity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.littlejoy.ui.theme.LittleJoyTheme
import java.sql.Date
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.core.content.ContextCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleJoyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val testEvents = listOf(
                        Event("In the Heights", Date.valueOf("2021-6-10")),
                        Event("Tammie's Bachlorette Party", Date.valueOf("2021-9-8")),
                        Event("Linda's Wedding", Date.valueOf("2021-10-30"))
                    )
                    EventsList(testEvents)
                }
            }
        }
    }
}

@Composable
fun EventsList(events: List<Event>) {
    LazyColumn {
        items(events) { event ->
            EventRow(event)
        }
    }
}

@Composable
fun EventRow(event: Event) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(getNextColor())
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                text = event.eventName,
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 32.sp
            )
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                text = event.eventTime.toString(),
                color = Color.White,
                fontSize = 20.sp
            )
        }
    }
}

var cardColorNumber = 1

fun getNextColor(): Color {

    var colorToReturn = Color(0xFFE36857)

    // TODO Figure out how to get color from resources
    when (cardColorNumber) {
        1 -> colorToReturn = Color(0xFFE36857)
        2 -> colorToReturn = Color(0xFF28A0A1)
        else -> colorToReturn = Color(0xFF4392C0)
    }

    if (cardColorNumber == 3) {
        cardColorNumber = 1
    } else {
        cardColorNumber++
    }

    return colorToReturn
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val testEvents = listOf(
        Event("In the Heights", Date.valueOf("2021-6-10")),
        Event("Tammie's Bachlorette Party", Date.valueOf("2021-9-8")),
        Event("Linda's Wedding", Date.valueOf("2021-10-30"))
    )

    // Preview list
//    LittleJoyTheme {
//        EventsList(testEvents)
//    }

    // Preview list item
    EventRow(Event("Latte's Birthday", Date.valueOf("2021-7-30")))
}