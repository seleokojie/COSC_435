package edu.towson.cosc435.labsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
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
                Surface(color = MaterialTheme.colors.background) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.titlec2f),
            fontSize = 28.sp,
            modifier = Modifier.padding(16.dp)
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(stringResource(R.string.placeholder))
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions
                .Default
                .copy(keyboardType = KeyboardType.Number, imeAction = ImeAction.Go),
            modifier = Modifier.padding(16.dp)
        )
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            RadioButton(
                selected = true,
                onClick = {}
            )
            Text(stringResource(id = R.string.f2c_label))
        }
        Row {
            RadioButton(
                selected = false,
                onClick = {}
            )
            Text(stringResource(id = R.string.c2f_label))
        }
        Button(
            onClick = {},
            modifier = Modifier.padding(16.dp)
        ) {
            Text(stringResource(R.string.convert_btn))
        }
        Text(stringResource(R.string.result_label))
        Text(
            text = "",
            fontSize = 28.sp
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

// TODO - 1. Add a mutableState object to hold the original temp input value
// TODO - 2. Use the state as the value of the TextField, update the value on change
// TODO - 3. Create an enum to represent the state of the radio buttons
// TODO - 4. Add a mutableState object to hold the state of the radio buttons
// TODO - 5. Update the radio state on change
// TODO - 6. Add a mutableState object to hold the result text value
// TODO - 7. Create a function to compute the temperature change
// TODO - 8. Call the function with the current state when the button is clicked
// TODO - 9. Set the result value with the function's result
// TODO - 10. Handle errors gracefully
// TODO - 11. (Optional) Update the result when the radio buttons change
// TODO - 12. (Optional) Dismiss the keyboard and update the result when "Enter/Go" is pressed
// TODO - 13. (Optional) Update the title when the radio buttons change
