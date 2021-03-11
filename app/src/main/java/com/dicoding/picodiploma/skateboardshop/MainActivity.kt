package com.dicoding.picodiploma.skateboardshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var rvBoard: RecyclerView
    private var list: ArrayList<Board> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAbout: Button = findViewById(R.id.btn_about)
        btnAbout.setOnClickListener(this)

        rvBoard = findViewById(R.id.rv_boards)
        rvBoard.setHasFixedSize(true)

        list.addAll(BoardData.listData)
        showRecyclerList()
    }

    override fun onClick(v:View){
        if (v.id==R.id.btn_about){
            val aboutIntent = Intent(this@MainActivity,aboutActivity::class.java)
            startActivity(aboutIntent)
            }
        }

    private fun showRecyclerList(){
        rvBoard.layoutManager = LinearLayoutManager(this)
        val listBoardAdapter = ListBoardAdapter(list)
        rvBoard.adapter = listBoardAdapter
    }
}