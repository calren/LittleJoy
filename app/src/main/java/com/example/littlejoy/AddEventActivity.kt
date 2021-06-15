package com.example.littlejoy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.*
import androidx.compose.material.Text
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.input.TextFieldValue
import com.example.littlejoy.ui.theme.LittleJoyTheme

class AddEventActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LittleJoyTheme {
                editText()
            }
        }
    }

    @Composable
    fun editText() {
        val textField = remember { mutableStateOf(TextFieldValue()) }

        TextField(
            value = textField.value,
            onValueChange = {
                textField.value  = it
            },
            placeholder = { Text(text = "Enter event name") }
        )
    }


}