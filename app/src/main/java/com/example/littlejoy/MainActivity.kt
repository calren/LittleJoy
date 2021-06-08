package com.example.littlejoy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.unit.dp
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.littlejoy.ui.theme.LittleJoyTheme
import java.sql.Date
import androidx.compose.foundation.lazy.items

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleJoyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val testEvents = listOf(Event("In the Heights", Date.valueOf("2021-6-10")))
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
    val padding = 10.dp
    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        Text(event.eventName)
        Text(event.eventTime.toString())
    }
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
    LittleJoyTheme {
        EventsList(testEvents)
    }

    // Preview list item
//    EventRow(Event("Latte's Birthday", Date.valueOf("2021-7-30")))
}