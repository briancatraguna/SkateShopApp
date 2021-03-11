package com.dicoding.picodiploma.skateboardshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class BoardDetail : AppCompatActivity() {

    private lateinit var currentBrand: TextView
    private lateinit var currentDetail: TextView
    private lateinit var currentPhoto: ImageView

    companion object {
        const val EXTRA_BRAND = "extra_brand"
        const val EXTRA_PRICE = "extra_price"
        const val EXTRA_MODEL = "extra_model"
        const val EXTRA_SIZE = "extra_size"
        const val EXTRA_PICTURE = "extra_picture"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_detail)

        val boardBrand = intent.getStringExtra(EXTRA_BRAND)
        val boardPrice = intent.getStringExtra(EXTRA_PRICE)
        val boardModel = intent.getStringExtra(EXTRA_MODEL)
        val boardSize = intent.getStringExtra(EXTRA_SIZE)
        val boardPhoto = intent.getIntExtra(EXTRA_PICTURE,0)

        val detail: String? = BoardDetails.boardDetail[boardBrand]
        if (detail != null && boardBrand != null){
            setDetailInformation(boardBrand,detail)
        }

        currentPhoto = findViewById(R.id.detail_photo)
        currentPhoto.setImageResource(boardPhoto)
    }

    private fun setDetailInformation(boardBrand: String,detail: String){
        currentBrand = findViewById(R.id.detail_brand)
        currentBrand.text = boardBrand.toString()
        currentDetail = findViewById(R.id.details)
        currentDetail.text = detail.toString()
    }
}