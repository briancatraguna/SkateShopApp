package com.dicoding.picodiploma.skateboardshop

object BoardData {
    private val boardBrands = arrayOf(
        "GX1000",
        "GX1000",
        "Palace Skateboards",
        "Passport",
        "SKATEDELUXE",
        "SKATEDELUXE",
        "SKATEDELUXE",
        "SKATEDELUXE",
        "SKATEDELUXE",
        "Uber Skateboards"
    )

    private val boardPrice = arrayOf(
        "65 EUR",
        "65 EUR",
        "70 EUR",
        "70 EUR",
        "50 EUR",
        "50 EUR",
        "50 EUR",
        "50 EUR",
        "50 EUR",
        "55 EUR"
    )

    private val boardModel = arrayOf(
        "Pig 1",
        "Pig 3",
        "Da Silva Church",
        "What U Thought",
        "Acid",
        "Ice Cream",
        "Joy Of Skating",
        "Rose",
        "Solojazz",
        "Piss Boy"
    )

    private val boardSize = arrayOf(
        "8.375\"",
        "8.25\"",
        "8.375\"",
        "8.38\"",
        "8.5\"",
        "8.25\"",
        "7.75\"",
        "8.5\"",
        "8.5\"",
        "8.25\""
    )

    private val boardImages = intArrayOf(
        R.drawable.gx1000_65_pig1_8375,
        R.drawable.gx1000_65_pig3_825,
        R.drawable.palaceskateboards_70_dasilvachurch_8375,
        R.drawable.passport_70_whatuthought_838,
        R.drawable.skatedeluxe_50_acid_85,
        R.drawable.skatedeluxe_50_icecream_825,
        R.drawable.skatedeluxe_50_joyofskating_775,
        R.drawable.skatedeluxe_50_rose_85,
        R.drawable.skatedeluxe_50_solojazz_85,
        R.drawable.uberskateboards_55_pissboy_825
    )

    val listData: ArrayList<Board>
    get(){
        val list = arrayListOf<Board>()
        for (position in boardBrands.indices){
            val board = Board()
            board.brand = boardBrands[position]
            board.price = boardPrice[position]
            board.model = boardModel[position]
            board.size = boardSize[position]
            board.photo = boardImages[position]
            list.add(board)
        }
        return list
    }
}