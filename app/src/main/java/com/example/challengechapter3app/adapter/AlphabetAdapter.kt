package com.example.challengechapter3app.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.challengechapter3app.DataWord
import com.example.challengechapter3app.R
import com.example.challengechapter3app.data.Word
import com.example.challengechapter3app.fragment.OptionFragment

class AlphabetAdapter(private val listAlphabet : ArrayList<DataWord>) : RecyclerView.Adapter<AlphabetAdapter.ViewHolder>() {
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
            val bundleData = Bundle().apply {
                putStringArrayList("DATA_WORD", Word.dataWord.getValue(listAlphabet[position].word))
            }

            val fragmentMove = OptionFragment()
            setFragment(holder, fragmentMove, bundleData)

        }
    }

    private fun setFragment(holder : ViewHolder, fragment : Fragment, bundleData: Bundle){
        fragment.arguments = bundleData
        (holder.itemView.context as AppCompatActivity).supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
    }
}