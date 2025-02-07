package com.example.topappbaretc

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Nav01() {
	val navigationController = rememberNavController()
	NavHost(navController = navigationController, startDestination = "Screen01") {
		composable(route = "Screen01") { Pantalla01(navController = navigationController) }
		composable(route = "Screen02") { Pantalla02(navController = navigationController) }
	}
}

@Composable
fun Pantalla01(navController: NavHostController) {
	Box(
		Modifier
			.fillMaxSize()
			.background(Color.Red)
	) {
		Button(modifier = Modifier.align(Alignment.Center),
			onClick = { navController.navigate("Screen02") }) {
			Text(
			text = "Ir pantalla 2",
		) }

	}
}

@Composable
fun Pantalla02(navController: NavHostController) {

	Box(
		Modifier
			.fillMaxSize()
			.background(Color.Yellow)
			, contentAlignment = Alignment.Center
	) {
	Column (horizontalAlignment = Alignment.CenterHorizontally){
		Text("Texto estatico") //no se ve el texto
		Spacer(modifier = Modifier.height(10.dp
		))
		Button(
			onClick = { navController.popBackStack() }) {
			Text(
				text = "Volver pantalla 1",

				)
		}
	}



	}
}