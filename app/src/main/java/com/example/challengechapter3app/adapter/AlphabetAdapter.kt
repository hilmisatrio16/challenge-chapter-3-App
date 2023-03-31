package com.example.challengechapter3app.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.challengechapter3app.DataWord
import com.example.challengechapter3app.R
import com.example.challengechapter3app.data.Word
import com.example.challengechapter3app.fragment.HomeFragmentDirections
import com.example.challengechapter3app.fragment.OptionFragment

class AlphabetAdapter(private val context : Context ,private val listAlphabet : ArrayList<DataWord>) : RecyclerView.Adapter<AlphabetAdapter.ViewHolder>() {
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val btnAlphabet: Button = view.findViewById(R.id.btnHuruf)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_word, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listAlphabet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.btnAlphabet.text = listAlphabet[position].word
        holder.btnAlphabet.setOnClickListener {
            //mengirim data antar fragment
            val arrDataWord = Word.dataWord.getValue(listAlphabet[position].word).toTypedArray()
            //nav component passing data dengan safeargs
            val directionNav = HomeFragmentDirections.actionHomeFragmentToOptionFragment(arrDataWord)
            Navigation.findNavController(it).navigate(directionNav)
            Toast.makeText(context, "You choose alphabet ${listAlphabet[position].word}", Toast.LENGTH_SHORT).show()
        }

    }

}