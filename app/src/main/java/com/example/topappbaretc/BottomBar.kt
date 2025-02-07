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
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun MyBottomBar(index: Int ,Selected: (Int) -> Unit) {


	NavigationBar(
		contentColor = Color.White,
	) {

		NavigationBarItem(
			selected = index==1,
			onClick = {Selected(1) },
			icon = {
				Box(
					modifier = Modifier
						.background(
							color = Color.Blue, shape = CircleShape
						)
						.padding(horizontal = 20.dp, vertical = 12.dp)
				) {
					Text(
						text = "Pantalla A", color = Color.White
					)
				}
			}
		)
		NavigationBarItem(
			selected = index==2,
			onClick = { Selected(2)},

			icon = {
				Box(
					modifier = Modifier
						.background(
							color = Color.Blue, shape = CircleShape
						)
						.padding(horizontal = 20.dp, vertical = 12.dp)
				) {
					Text(
						text = "Pantalla B", color = Color.White
					)
				}
			}


		)
	}


}


@Composable
fun ScaffoldEjemplo3() {

	var index by remember{
		mutableStateOf(1)
	}

	val snackbarHostState = SnackbarHostState()

	Scaffold(
		snackbarHost = { SnackbarHost(snackbarHostState) },
		bottomBar = { MyBottomBar(index){index = it} },

	) { contentPadding -> PantallA(modifier = Modifier.padding(contentPadding),index)
	}

}

@Composable
fun PantallA(modifier: Modifier,index: Int) {
	Box(
		Modifier
			.fillMaxSize()
			.background(Color.LightGray).systemBarsPadding(), Alignment.Center
	) {
		if (index==1){
			Text(text = "Estas en la pantalla A", fontSize = 30.sp)
		}else{
			Text(text = "Estas en la pantalla B", fontSize = 30.sp)

		}

	}
}

