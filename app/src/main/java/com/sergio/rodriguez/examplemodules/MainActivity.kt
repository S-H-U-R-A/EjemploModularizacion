package com.sergio.rodriguez.examplemodules

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.sergio.rodriguez.domain.Location
import com.sergio.rodriguez.examplemodules.ui.theme.ExampleModulesTheme
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampleModulesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ListLocation()
                }
            }
        }
    }
}


@Composable
fun ListLocation(
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember{ MutableInteractionSource() },
    viewModel: MainViewModel = MainViewModel()
){

    val stateUiViewModel = viewModel.uistate.collectAsState()

    viewModel.getLocationNetwork()

    LazyColumn(){
        items(stateUiViewModel.value.locations.size){
            ItemsListLocation(locationObj = stateUiViewModel.value.locations[it])
        }
    }

}

@Composable
fun ItemsListLocation(
    locationObj: Location,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember{ MutableInteractionSource() }
) {
    Row(
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Default.LocationOn,
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(width = 16.dp))
        Text(
            text = "Latitud: ${locationObj.latitude} * Longitud:${locationObj.longitude}"
        )
    }
}

//MOSTRAR DATOS CON PREVIEW PARAMETER
class LocationProvider: PreviewParameterProvider<Location>{
    override val values: Sequence<Location>
        get() = sequenceOf(
            Location(
                latitude = 72.561155,
                longitude = 7.3589,
                date = LocalDate.now()
            ),
        )
}

@Preview(apiLevel = 33, showBackground = true)
@Composable
fun MyItemPreview(
    @PreviewParameter(LocationProvider::class) location: Location
){
    ExampleModulesTheme {
        ItemsListLocation(locationObj = location)
    }
}


@Preview(showSystemUi = true, apiLevel = 33)
@Composable
fun AppPreview() {
    ExampleModulesTheme {
        ListLocation()
    }
}