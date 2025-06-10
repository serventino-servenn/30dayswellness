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
        Exercise(R.string.exercise1,16,3,R.drawable.yoga_2),
        Exercise(R.string.exercise2,20,1,R.drawable.running),
        Exercise(R.string.exercise3,17,4,R.drawable.weight),
        Exercise(R.string.exercise4,30,2,R.drawable.push_ups),
        Exercise(R.string.exercise5,12,1,R.drawable.jumping_jack),
        Exercise(R.string.exercise6,10,2,R.drawable.lunges) ,
        Exercise(R.string.exercise7,10,1,R.drawable.plank),
        Exercise(R.string.exercise8,20,1,R.drawable.tricep_dip)
    )
}
