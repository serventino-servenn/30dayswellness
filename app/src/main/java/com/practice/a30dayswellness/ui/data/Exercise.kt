package com.practice.a30dayswellness.ui.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.practice.a30dayswellness.R

data class Exercise(
    @StringRes val name:Int,
    val duration:Int,
    val numberOfExercises:Int,
    @DrawableRes val img:Int
)

object ExerciseList{
    val exercise = listOf(
        Exercise(R.string.exercise1,3,16,R.drawable.yoga_2),
        Exercise(R.string.exercise2,2,20,R.drawable.running),
        Exercise(R.string.exercise3,4,17,R.drawable.weight),
        Exercise(R.string.exercise4,3,30,R.drawable.push_ups),
        Exercise(R.string.exercise5,4,12,R.drawable.jumping_jack),
        Exercise(R.string.exercise6,2,10,R.drawable.lunges) ,
        Exercise(R.string.exercise7,2,10,R.drawable.plank),
        Exercise(R.string.exercise8,2,30,R.drawable.yoga_2)
    )
}
