package com.example.challengechapter3app.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.challengechapter3app.DataWord
import com.example.challengechapter3app.R

class WordAdapter(private val listWord : ArrayList<DataWord>) : RecyclerView.Adapter<WordAdapter.ViewHolder>() {

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val btnWord : Button = view.findViewById(R.id.btnHuruf)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_word, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.btnWord.text = listWord[position].word

        holder.btnWord.setOnClickListener {
            //intent implicit
            val keyword = listWord[position].word
            val moveToWeb = Intent(Intent.ACTION_VIEW)
            moveToWeb.data = Uri.parse("https://www.google.com/search?q=$keyword")
            holder.btnWord.context.startActivity(moveToWeb)
        }
    }

    override fun getItemCount(): Int {
        return listWord.size
    }
}