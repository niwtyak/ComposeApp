package com.example.matelial2app

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.matelial2app.client.RetrofitClient
import com.example.matelial2app.interfaces.RetrofitServices
import com.example.matelial2app.navigation.NavGraph
import com.example.matelial2app.ui.theme.Matelial2appTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val flaskApi = RetrofitClient.getClient().create(RetrofitServices::class.java)

        GlobalScope.launch {
            try {
                val response = flaskApi.getUsers()
                if (response.isSuccessful) {
                    Log.d("response",response.body().toString())


                } else {
                    Toast.makeText(
                        this@MainActivity,
                        response.errorBody().toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            } catch (Ex: Exception) {
                Log.e("error", Ex.localizedMessage as String)
            }
        }

        setContent {
            Matelial2appTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    val navController = rememberNavController()
                    NavGraph(navController = navController, retrofitClient = flaskApi)
                }

            }
        }
    }
}



