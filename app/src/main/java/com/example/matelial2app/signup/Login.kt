package com.example.matelial2app.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.matelial2app.client.RetrofitClient
import com.example.matelial2app.interfaces.RetrofitServices


@Composable
fun Login(navController: NavController,retrofitClient: RetrofitServices) {
    var loginValue by remember { mutableStateOf(TextFieldValue("")) }
    var passwordValue by remember { mutableStateOf(TextFieldValue("")) }

    Surface(color = Color.White) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = loginValue,
                onValueChange = { loginValue = it },
                label = { Text(text = "Name") },
                placeholder = { Text(text = "Name") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = passwordValue,
                onValueChange = { passwordValue = it },
                label = { Text(text = "Password") },
                placeholder = { Text(text = "Password") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(onClick = {

            },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "ENTER", modifier = Modifier.padding(8.dp))
            }

        }
    }
}