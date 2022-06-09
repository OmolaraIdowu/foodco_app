package com.swancodes.foodco.fragments

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.swancodes.foodco.R
import com.swancodes.foodco.adapter.FoodListAdapter
import com.swancodes.foodco.data.DataSource
import com.swancodes.foodco.databinding.FragmentFoodListBinding

class FoodListFragment : Fragment() {
    private var _binding: FragmentFoodListBinding? = null
    private val binding get() = _binding!!

    private val myDataset = DataSource().loadFood()

    private lateinit var recyclerView: RecyclerView

    private var isGridLayoutManager = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentFoodListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView

        selectLayout()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.layout_menu, menu)

        val layoutButton = menu.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)
    }

    private fun selectLayout() {
        if (isGridLayoutManager) {
            recyclerView.layoutManager = GridLayoutManager(context, 2)
        } else {
            recyclerView.layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }
        recyclerView.adapter = FoodListAdapter(dataset = myDataset, onFoodItemClicked = {
            val directions = FoodListFragmentDirections.toFoodDetailsFragment(it)
            findNavController().navigate(directions)
        })
    }

    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return

        menuItem.icon =
            if (isGridLayoutManager)
                ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_grid_layout)
            else ContextCompat.getDrawable(this.requireContext(),
                R.drawable.ic_staggered_grid_layout)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                isGridLayoutManager = !isGridLayoutManager
                selectLayout()
                setIcon(item)

                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}