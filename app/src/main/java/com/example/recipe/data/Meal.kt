package com.example.recipe.data

import androidx.room.Entity

@Entity(tableName = "favorites")
data class Meal(
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String
)