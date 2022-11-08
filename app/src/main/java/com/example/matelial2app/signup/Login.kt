package com.example.matelial2app.signup

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.matelial2app.client.RetrofitClient
import com.example.matelial2app.interfaces.RetrofitServices
import com.example.matelial2app.models.LoginInfo
import com.example.matelial2app.models.UserKeys
import kotlinx.coroutines.launch


@Composable
fun Login(
    navController: NavController,
    flaskApi: RetrofitServices,
    viewModel: SingupViewModel = viewModel()
) {
    var loginValue by remember { mutableStateOf(TextFieldValue("")) }
    var passwordValue by remember { mutableStateOf(TextFieldValue("")) }
    val coroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    Surface(color = Color.White) {
        Scaffold() {

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

                Button(
                    onClick = {
                        val loginInfo = LoginInfo(loginValue.text,passwordValue.text)
                        coroutineScope.launch() {
                            try {
                                val response = flaskApi.login(loginInfo)
                                if (response.isSuccessful) {
                                    val keys = response.body()
                                    viewModel.setKeys(response.body()?: throw Exception("no keys"))
                                    Log.d("response", response.body().toString())

                                } else {
                                    scaffoldState.snackbarHostState
                                        .showSnackbar(
                                            message = "not ok",
                                            actionLabel = "ok",
                                            duration = SnackbarDuration.Indefinite
                                        )
                                }
                            } catch (Ex: Exception) {
                                Log.e("error", Ex.localizedMessage as String)
                            }
                        }

                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = "ENTER", modifier = Modifier.padding(8.dp))
                }

            }
        }
    }
}