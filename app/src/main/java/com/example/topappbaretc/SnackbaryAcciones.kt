package com.example.topappbaretc

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable


fun MySnackbar() {

	val snackbarHostState = remember { SnackbarHostState() }

	val context = LocalContext.current

	val scope = rememberCoroutineScope()


	Scaffold(
		snackbarHost = {

			SnackbarHost(hostState = snackbarHostState)
		}
	) { paddingValues ->

		Box(
			modifier = Modifier
				.fillMaxSize()
				.padding(paddingValues)
				.background(Color.White),
			contentAlignment = androidx.compose.ui.Alignment.Center
		) {

			Button(onClick = {

				scope.launch {
					val snackbarResult = snackbarHostState.showSnackbar(
						message = "Se realizó una acción",
						actionLabel = "Deshacer"
					)

					if (snackbarResult == SnackbarResult.ActionPerformed) {
						Toast.makeText(context, "Acción deshecha", Toast.LENGTH_SHORT).show()
					}
				}
			}) {
				Text("Presionar")
			}
		}
	}
}


