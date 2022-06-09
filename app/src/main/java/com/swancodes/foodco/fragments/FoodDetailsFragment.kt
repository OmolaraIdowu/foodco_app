package com.swancodes.foodco.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.swancodes.foodco.databinding.FragmentFoodDetailsBinding

class FoodDetailsFragment : Fragment() {
    private var _binding: FragmentFoodDetailsBinding? = null

    private val binding get() = _binding!!
    private val args by navArgs<FoodDetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentFoodDetailsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val food = args.food
        binding.apply {
            foodName.text = food.name
            foodPrice.text = food.price
            foodImage.setImageResource(food.imageResourceId)
            foodDetails.text = getString(food.details)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

