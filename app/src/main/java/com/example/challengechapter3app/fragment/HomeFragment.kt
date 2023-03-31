package com.example.challengechapter3app.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challengechapter3app.DataWord
import com.example.challengechapter3app.R
import com.example.challengechapter3app.adapter.AlphabetAdapter
import com.example.challengechapter3app.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var listDataHuruf = ArrayList<DataWord>()

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.setHasFixedSize(true)

        listDataHuruf.addAll(getAbjad())
        showRecyclerview()

        (activity as AppCompatActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(false)


    }
    fun changeLayoutRecycleview(layout : String) {
        when (layout) {

            "list" -> {
                binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
            }
            "grid" -> {
                binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
            }
        }
    }

    private fun showRecyclerview() {
        binding.recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val alphabetAdapter = AlphabetAdapter(requireContext(), listDataHuruf)
        binding.recyclerView.adapter = alphabetAdapter
    }

    private fun getAbjad() : ArrayList<DataWord>{
        val dataHurufAbjad = resources.getStringArray(R.array.data_abjad)
        val list = ArrayList<DataWord>()

        for (i in dataHurufAbjad.indices){
            list.add(DataWord(dataHurufAbjad[i]))
            Log.d("Cek list", list[i].toString())
        }

        return list
    }
}