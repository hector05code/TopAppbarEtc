package com.example.topappbaretc

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScreen() {
	val snackbarHostState = remember { SnackbarHostState() }
	val scope = rememberCoroutineScope()

	Scaffold(
		topBar = {
			MyTopAppBar(onOptionSelected = { option ->
				scope.launch {
					snackbarHostState.showSnackbar("Seleccionaste $option")
				}
			})
		},
		snackbarHost = {
			SnackbarHost(hostState = snackbarHostState)
		}
	) { innerPadding ->
		Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {

		}
	}
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun MyTopAppBar(onOptionSelected: (String) -> Unit){

	var abrirmenu by remember { mutableStateOf(false) }
	val snackbarHostState = SnackbarHostState()

	Column (Modifier.fillMaxWidth()){ TopAppBar(modifier = Modifier.windowInsetsPadding(  // para que no ocupe la parte de arriba del movil
		WindowInsets.statusBars.only(WindowInsetsSides.Top)
	),
		title = { Text("TopAppBar") },
		colors = TopAppBarDefaults.topAppBarColors(
			containerColor = Color.Red, // Color de fondo
			titleContentColor = Color.White // Color del título
		),
		navigationIcon = { IconButton(onClick = { abrirmenu = true })
		{Icon(imageVector = Icons.Default.Menu, contentDescription = "",) } },
	)

		DropdownMenu(
			expanded = abrirmenu,
			onDismissRequest = { abrirmenu = false }
		) {
			DropdownMenuItem(

				text = { Text("Opcion 1") },
				onClick = {
					onOptionSelected("Opción 1")
					abrirmenu = false
				}
			)
			DropdownMenuItem(
				text = { Text("Opcion 2") },
				onClick = {
					onOptionSelected("Opción 2")
					abrirmenu = false
				}
			)

		} }



}