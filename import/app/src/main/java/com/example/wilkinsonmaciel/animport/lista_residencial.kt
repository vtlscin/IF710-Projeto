package com.example.wilkinsonmaciel.animport

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_lista_residencial.*
import kotlinx.android.synthetic.main.app_bar_lista_residencial.*
import kotlinx.android.synthetic.main.content_lista_residencial.*

class lista_residencial : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    val itemList: MutableList<item_residencial> = mutableListOf(
            item_residencial("Limpeza de Cama", "49,99", "Quero"),
            item_residencial("Limpeza de Estofados", "59,99", "Quero"),
            item_residencial("Limpeza de Tapetes", "49,99", "Quero")
    )

    lateinit var item_residencialAdapter: item_residencialAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_residencial)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            startActivity( Intent( this ,calendario::class.java))
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        item_residencialAdapter = item_residencialAdapter(this, itemList)
        recyclerView2.adapter = item_residencialAdapter
        recyclerView2.layoutManager = LinearLayoutManager(this)
        recyclerView2.smoothScrollToPosition(itemList.size)

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.lista_residencial, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.carrinho -> {
                // Handle the camera action
            }
            R.id.alterar -> {

            }
            R.id.compras -> {

            }
            R.id.sobre -> {

            }
            R.id.sair -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
