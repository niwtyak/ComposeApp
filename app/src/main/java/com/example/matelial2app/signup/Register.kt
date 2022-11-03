package com.example.matelial2app.signup

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import com.example.matelial2app.client.RetrofitClient
import com.example.matelial2app.interfaces.RetrofitServices
import com.example.matelial2app.models.Role
import com.example.matelial2app.models.User
import com.example.matelial2app.models.UserRegister
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

@Composable
fun Register(navController: NavController, flaskApi: RetrofitServices) {
    var expanded by remember { mutableStateOf(false) }
    var selectedRole by remember { mutableStateOf("admin") }
    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp //it requires androidx.compose.material:material-icons-extended
    else
        Icons.Filled.ArrowDropDown

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

            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                OutlinedTextField(
                    value = selectedRole,
                    onValueChange = {},
                    label = { Text(text = "Role") },
                    modifier = Modifier
                        .fillMaxWidth(),
                    trailingIcon = {
                        Icon(icon, "contentDescription",
                            Modifier.clickable { expanded = !expanded })
                    }
                )

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Role.values().forEach { role ->
                        DropdownMenuItem(onClick = {
                            selectedRole = role.toString()
                            expanded = false
                        }) {
                            Text(text = role.toString())
                        }
                    }
                }
            }

            Button(
                onClick = {
                    val newUser = UserRegister(
                        name = loginValue.text,
                        password = passwordValue.text,
                        role = selectedRole
                    )

                    GlobalScope.launch() {
                        try {
                        val response = flaskApi.register(newUser)
                        if (response.isSuccessful) {
                            Log.d("response", response.body().toString())

                        } else {

                        }
                    } catch (Ex: Exception) {
                    Log.e("error", Ex.localizedMessage as String)
                }
                }
        },
        modifier = Modifier.padding(8.dp)
        ) {
        Text(text = "REGISTER", modifier = Modifier.padding(8.dp))
    }
    }
}
}