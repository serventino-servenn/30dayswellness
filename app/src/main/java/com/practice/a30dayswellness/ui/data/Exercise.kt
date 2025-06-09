package com.practice.a30dayswellness.ui.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.practice.a30dayswellness.R

data class Exercise(
    @StringRes val name:Int,
    val numberOfExercises:Int,
    val duration:Int,
    @DrawableRes val img:Int
)

object ExerciseList{
    val exercise = listOf(
        Exercise(R.string.exercise1,3,15,R.drawable.yoga_2),
        Exercise(R.string.exercise2,2,20,R.drawable.running),
        Exercise(R.string.exercise3,4,18,R.drawable.yoga),
        Exercise(R.string.exercise4,5,16,R.drawable.yoga),
        Exercise(R.string.exercise5,3,16,R.drawable.yoga),
        Exercise(R.string.exercise6,1,20,R.drawable.yoga) ,
        Exercise(R.string.exercise7,3,19,R.drawable.yoga),
        Exercise(R.string.exercise8,4,20,R.drawable.yoga)
    )
}
