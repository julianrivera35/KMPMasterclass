package andes.campus.analytic.pg.screens

import andes.campus.analytic.pg.Platform
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AboutScreen(
    onUpButtonClick:() -> Unit
){
    Column {
        Toolbar(onUpButtonClick)
        ContentView()
    }
}

@Composable
private fun Toolbar(
    onUpButtonClick:() -> Unit
){
    TopAppBar(
        title = { Text(text = "About device") },
        navigationIcon = {
            IconButton(onClick = onUpButtonClick) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Up Button",
                )
            }
        }
    )
}

@Composable
private fun ContentView (){
    val items = makeItems()

    LazyColumn (modifier = Modifier.fillMaxSize(),)
    {
     items(items){ item -> RowView(title = item.first, subtitle = item.second) }
    }
}


private fun makeItems(): List<Pair<String,String>>{
    val platform = Platform()
    platform.logSystemInfo()

    return listOf(
        Pair("Operating System", "${platform.osName} ${platform.osVersion}"),
        Pair("Device", platform.deviceModel),
        Pair("Density", platform.density.toString())
    )
}

@Composable
private fun RowView(title:String, subtitle:String){
    Column (Modifier.padding(8.dp)){
        Text(
            text = title,
            style = MaterialTheme.typography.body2,
            color = Color.Gray
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.body1,
        )
    }
    Divider()
}