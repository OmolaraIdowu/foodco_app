package com.swancodes.foodco.data

import com.swancodes.foodco.R
import com.swancodes.foodco.model.Food

class DataSource {
    fun loadFood(): List<Food> {
        return listOf(
            Food(R.drawable.food_image1, "Roasted Chicken", "$45.65", R.string.roasted_chicken),
            Food(R.drawable.food_image2, "Million Truffle", "$17.95", R.string.million_truffle),
            Food(R.drawable.food_image3, "Sushi", "$18.95", R.string.sushi),
            Food(R.drawable.food_image4,
                "Lemon Ricotta Flatbread",
                "$13.95",
                R.string.lemon_ricotta_flatbread),
            Food(R.drawable.food_image5, "Steak and Potatoes", "$16", R.string.steak_and_potatoes),
            Food(R.drawable.food_image6, "Waffles", "$14.50", R.string.waffles),
            Food(R.drawable.food_image7, "Junk Food", "$40.65", R.string.junk_food),
            Food(R.drawable.food_image8, "Parrilla Mixta", "$16.50", R.string.parrilla_mixta),
            Food(R.drawable.food_image9, "Pizza", "$24", R.string.pizza),
            Food(R.drawable.food_image10, "Poke Bowl", "$14.50", R.string.pole_bowl),
            Food(R.drawable.food_image11, "Salad", "$12.5", R.string.salads),
            Food(R.drawable.food_image12, "Hamburger", "$12.95", R.string.hamburger),
            Food(R.drawable.food_image13, "Sandwich", "$34", R.string.sandwich),
            Food(R.drawable.food_image14, "Hot Dog", "$12", R.string.hot_dog),
            Food(R.drawable.food_image15,
                "Salmon and veggies",
                "$11.50",
                R.string.salmon_and_veggies)
        )
    }
}
