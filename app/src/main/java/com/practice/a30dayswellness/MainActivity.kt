package com.practice.a30dayswellness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.practice.a30dayswellness.ui.data.Exercise
import com.practice.a30dayswellness.ui.data.ExerciseList
import com.practice.a30dayswellness.ui.theme.WellnessAppTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WellnessAppTheme {
                Scaffold(
                    topBar = {
                        WellnessTopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                titleContentColor = Color.White
                            )
                        )

                    }
                ) {innerPadding ->
                    WellnessApp(
                       modifier = Modifier.padding(innerPadding)
                   )
                }
            }
        }
    }
}

@Composable
fun WellnessApp(modifier: Modifier = Modifier){
    WellnessList(
        exercises = ExerciseList.exercise,
        modifier = modifier
            .fillMaxSize()
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WellnessTopAppBar(colors: TopAppBarColors? = null) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.titleLarge
            )
        },
        colors = colors?: TopAppBarDefaults.topAppBarColors(),
    )
}

@Composable
fun WellnessList(
    exercises:List<Exercise>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(
            vertical = dimensionResource(id = R.dimen.padding_large),
            horizontal = dimensionResource(id = R.dimen.padding_large)
        ),
        modifier = modifier
    ) {
        itemsIndexed(exercises) {index, exercise ->
            WellnessItem(
                activity = exercise,
                day = index + 1
            )
        }
    }

}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun WellnessItem(
    activity:Exercise,
    day:Int,
    modifier: Modifier = Modifier
) {
    var isPressed by remember {mutableStateOf(false)}
    val color by animateColorAsState(
        targetValue = if(isPressed) MaterialTheme.colorScheme.tertiaryContainer
        else MaterialTheme.colorScheme.primaryContainer,
    )
   Card(
       elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
       colors = CardDefaults.cardColors(
           containerColor = MaterialTheme.colorScheme.primaryContainer
       ),
       modifier = modifier
   ) {
       Column(
           horizontalAlignment = Alignment.CenterHorizontally,
           modifier = Modifier
               .background(color = color)

       ) {
           Row(
               horizontalArrangement = Arrangement.SpaceBetween,
               modifier = Modifier.fillMaxWidth()
           ) {
               DayLabel(day = day)
               WellnessButton(
                   isPressed = isPressed,
                   onClick = {isPressed = !isPressed }
               )
           }
           WellnessCardBodyContent(
               activity = activity,
               isPressed = isPressed
           )
       }
   }
}

@Composable
fun WellnessCardBodyContent(
    activity:Exercise,
    isPressed:Boolean
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.size(150.dp)

    ){
        Text(
            text = stringResource(id = activity.name),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 10.dp, top = 10.dp)
        )
        AnimatedContent(
            targetState = isPressed,
            label = "ToggleContent"
        ) {showInfo ->
            if(showInfo){
                WellnessCardInfo(activityInfo = activity)
            }else{
                Image(
                    painter = painterResource(id = activity.img),
                    contentDescription = null,
                )
            }
        }

    }
}

@Composable
fun DayLabel(
    day:Int,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .padding(
                start = dimensionResource(id = R.dimen.padding_medium),
                top = dimensionResource(id = R.dimen.padding_medium)
            )
            .clip(
                shape = RoundedCornerShape(50.dp)
            )
            .background(colorResource(id = R.color.black))

    ){
        Text(
            text = stringResource(id = R.string.day_label, day),
            color = colorResource(id = R.color.white),
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding( dimensionResource(id = R.dimen.padding_medium))
        )
    }
}




@Composable
fun WellnessCardInfo(
    activityInfo:Exercise
){
  Column(
      horizontalAlignment = Alignment.CenterHorizontally
  ) {
      Text(
          text = stringResource(id = R.string.exercise_count, activityInfo.numberOfExercises),
          style = MaterialTheme.typography.bodyMedium
      )
      Text(
          text = stringResource(id = R.string.exercise_duration, activityInfo.duration),
          style = MaterialTheme.typography.bodyMedium
      )
  }
}

@Composable
fun WellnessButton(
    isPressed:Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if(isPressed) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
            contentDescription = if(isPressed) "Hide info" else "Show info"
        )
    }
}



@Preview(showBackground = true)
@Composable
fun WellNessListPreview() {
    WellnessAppTheme {
        WellnessList(exercises = ExerciseList.exercise)
    }
}