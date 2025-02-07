package com.example.topappbaretc

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
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyModalDrawer() {
	val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
	val navController = rememberNavController()
	ModalDrawer(drawerState = drawerState, navController = navController) {}
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun ModalDrawer(drawerState: DrawerState,navController: NavHostController,scaffold: @Composable () -> Unit){

	val scope = rememberCoroutineScope();

	ModalNavigationDrawer(
		drawerState = drawerState,
		gesturesEnabled = false,
		drawerContent = {
			ModalDrawerSheet {
				NavigationDrawerItem(
					label = { Text("Ir pantalla principal") },
					selected = false,
					onClick = { scope.launch { drawerState.close() }
						navController.navigate("Screen01") }
				)

				NavigationDrawerItem(
					label = { Text("Ir pantalla configuracion") },
					selected = false,
					onClick = {scope.launch { drawerState.close() }
						navController.navigate("Screen02")}
				)
			}
		}
	) { Scaffold(
		topBar = {
			TopAppBar(
				modifier = Modifier.windowInsetsPadding(
					WindowInsets.statusBars.only(WindowInsetsSides.Top)
				),
				title = { Text("TopAppBar") },
				colors = TopAppBarDefaults.topAppBarColors(
					containerColor = Color.Red,
					titleContentColor = Color.White
				),
				navigationIcon = {
					IconButton(onClick = { scope.launch { drawerState.open() } })
					{ Icon(imageVector = Icons.Default.Menu, contentDescription = "",) }
				},
			)
		}

	) { innerPadding ->
		NavHost(navController = navController, startDestination = "Screen01", modifier = Modifier.padding(innerPadding)) {
			composable(route = "Screen01") { PantallaPrincipal(navController = navController) }
			composable(route = "Screen02") { PantallaConf(navController = navController) }
		}

	} }

}


@Composable
fun PantallaPrincipal(navController: NavHostController) {
	Box(
		Modifier
			.fillMaxSize()
			.background(Color.Cyan)
	) {
		Text("Bienvenido a la aplicacion")
	}
}
@Composable
fun PantallaConf(navController: NavHostController) {
	Box(
		Modifier
			.fillMaxSize()
			.background(Color.LightGray)
	) {
		Text("Configuracion de la app")
	}
}