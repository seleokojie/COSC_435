package edu.towson.cosc435.labsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.towson.cosc435.labsapp.ui.theme.LabsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LabsAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier.border(1.dp, Color.Red),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        FormHeader()

        Spacer(modifier = Modifier.size(16.dp))

        FormRow(label = "Name")
        FormRow(label = "Artist")
        FormRow(label = "Album")
        FormRow(label = "Track")

        CheckBoxRow(label = "Is Awesome")

        Button(onClick = {}){
            Text("Save")
        }
    }
}

@Composable
fun FormRow(label: String){
    Row(
        modifier = Modifier
            .padding(top = 5.dp, bottom = 5.dp, start = 30.dp)
            .fillMaxWidth(),

        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = "$label:",
            modifier = Modifier
                .width(57.dp)
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text(label) }
        )
    }
}

@Composable
fun CheckBoxRow(label: String){
    Row(
        modifier = Modifier
            .padding(top = 5.dp, bottom = 5.dp, start = 5.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text("$label:")
        Checkbox(checked = false, onCheckedChange = {})
    }
}

@Composable
fun FormHeader(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(175.dp)
            .background(Color.Blue)
            .padding(32.dp),
        contentAlignment = Alignment.TopCenter
    ){
        Text(
            text = "Add new song",
            fontSize = 50.sp,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LabsAppTheme {
        MainScreen()
    }
}