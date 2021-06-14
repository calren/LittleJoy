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
import java.time.Duration
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.temporal.ChronoField

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleJoyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val testEvents = listOf(
                        Event(
                            1,
                            "In the Heights",
                            getInstantFromStringDate("2021-06-10").toEpochMilli()
                        ),
                        Event(
                            2,
                            "Tammie's Bachelorette Party",
                            getInstantFromStringDate("2021-09-08").toEpochMilli()
                        ),
                        Event(
                            3,
                            "Linda's Wedding",
                            getInstantFromStringDate("2021-10-30").toEpochMilli()
                        )
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
                text = getDaysUntilDate(Instant.ofEpochMilli(event.eventTime)).toString() + " days away!",
                color = Color.White,
                fontSize = 26.sp
            )
        }
    }
}

var cardColorNumber = 1

/**
 * With a list of predefined colors, gets the next color in the list so every item in the list will
 * have a different colored background.
 */
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

fun getDaysUntilDate(date: Instant): Int {
    val now = Instant.now()
    val diffInDates = Duration.between(now, date)
    val differenceInDays = diffInDates.toDays()
    return differenceInDays.toInt()
}

/**
 * Takes a string representation of a date in the form of YYYY-MM-DD and turns it into an Instant
 */
fun getInstantFromStringDate(date: String): Instant {
    return LocalDate.parse(date).atStartOfDay(ZoneId.systemDefault()).toInstant()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val testEvents = listOf(
        Event(1, "In the Heights", getInstantFromStringDate("2021-06-10").toEpochMilli()),
        Event(
            2,
            "Tammie's Bachelorette Party",
            getInstantFromStringDate("2021-09-08").toEpochMilli()
        ),
        Event(3, "Linda's Wedding", getInstantFromStringDate("2021-10-30").toEpochMilli())
    )

    // Preview list
//    LittleJoyTheme {
//        EventsList(testEvents)
//    }

    // Preview list item
    EventRow(Event(1, "Latte's Birthday", getInstantFromStringDate("2021-07-30").toEpochMilli()))
}