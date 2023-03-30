package com.example.challengechapter3app.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challengechapter3app.DataWord
import com.example.challengechapter3app.adapter.WordAdapter
import com.example.challengechapter3app.databinding.FragmentOptionBinding

class OptionFragment : Fragment() {

    private lateinit var binding: FragmentOptionBinding
    private var listWord = ArrayList<DataWord>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOptionBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val getList = arguments?.getStringArrayList("DATA_WORD")
        listWord.addAll(getDataList(getList!!))
        showRecyclerview()

        (activity as AppCompatActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)


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



    private fun getDataList(list : ArrayList<String>) : ArrayList<DataWord>{
        val listDataWord = ArrayList<DataWord>()
        for (i in list.indices){
            listDataWord.add(DataWord(list[i]))
        }

        return listDataWord
    }

    private fun showRecyclerview() {
        binding.recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val wordAdapter = WordAdapter(listWord)
        binding.recyclerView.adapter = wordAdapter
    }

}