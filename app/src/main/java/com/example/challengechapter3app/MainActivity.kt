package com.example.challengechapter3app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController
import com.example.challengechapter3app.databinding.ActivityMainBinding
import com.example.challengechapter3app.fragment.HomeFragment
import com.example.challengechapter3app.fragment.OptionFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentHome = HomeFragment()



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_app, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
                android.R.id.home -> {
                    findNavController(R.id.fragmentContainerView).navigate(R.id.action_optionFragment_to_homeFragment)
                }
                R.id.menu_list -> {
                    val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
                    if (fragment is HomeFragment) {
                        fragment.changeLayout("list")
                    }else if(fragment is OptionFragment){
                        fragment.changeLayout("list")
                    }
                    true
                }
                R.id.menu_grid -> {
                    val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
                    if (fragment is HomeFragment) {
                        fragment.changeLayout("grid")
                    }else if(fragment is OptionFragment){
                        fragment.changeLayout("grid")
                    }
                    true
                }
        }
        return super.onOptionsItemSelected(item)

    }


}