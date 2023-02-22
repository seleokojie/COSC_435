package edu.towson.cosc435.labsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
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
                // A surface container using the 'background' color from the theme
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
        // TODO - Add the header
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
    // Todo - Pick a Material color theme and apply it (https://material.io/resources)
}

@Composable
fun FormRow(label: String){
    //In order to make each form row start at the same place
    Row(
        modifier = Modifier
            //.border(2.dp, Color.Green)
            .padding(top = 5.dp, bottom = 5.dp)
            .fillMaxWidth(),

        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    //Note, to make the label be closer to the text field, we can use the horizontalArrangement
    //parameter to change the arrangement of the row
    //Specifically, we can use the SpaceAround parameter to make the label and text field closer
    ){
        Text(
            text = "$label:",
            modifier = Modifier
                .width(57.dp)
        )
        //Create an outlined text field with labels as the placeholder
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
            //.border(2.dp, Color.Green)
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