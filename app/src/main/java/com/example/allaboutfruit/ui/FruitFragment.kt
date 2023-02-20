package com.example.allaboutfruit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.allaboutfruit.data.model.FruitModel
import com.example.allaboutfruit.databinding.FragmentFruitBinding
import com.example.allaboutfruit.util.ResponseType
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FruitFragment: Fragment() {

    private var _binding: FragmentFruitBinding? = null

    private val binding get() = _binding!!

    private val viewModel: FruitViewModel by activityViewModels()

   override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

       _binding = FragmentFruitBinding.inflate(inflater, container, false)

       viewModel.result.observe(viewLifecycleOwner){
           when (it) {
               is ResponseType.Loading -> {
                   Toast.makeText(context, "Loading...", Toast.LENGTH_SHORT).show()
               }
               is ResponseType.Success -> {
                   initViews(it.data)
               }
               is ResponseType.Error -> {
                   Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
               }
           }
       }
       viewModel.getAllFruit()

       return binding.root
   }

    private fun initViews(data: FruitModel?) {
        data?.let{
            binding.rvFruit.layoutManager = GridLayoutManager(context, 3)
            binding.rvFruit.adapter = FruitAdapter(
                it
            ){
                //passes clickListener
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}