package com.dicoding.picodiploma.skateboardshop

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListBoardAdapter(private val listBoard: ArrayList<Board>): RecyclerView.Adapter<ListBoardAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvBoardBrand: TextView = itemView.findViewById(R.id.tv_board_brand)
        var tvBoardPrice: TextView = itemView.findViewById(R.id.tv_board_price)
        var tvBoardModel: TextView = itemView.findViewById(R.id.tv_board_model)
        var tvBoardSize: TextView = itemView.findViewById(R.id.tv_board_size)
        var tvBoardPhoto: ImageView = itemView.findViewById(R.id.img_board_photo)
        var btnDetails: Button = itemView.findViewById(R.id.btn_details)
        var btnCart: Button = itemView.findViewById(R.id.btn_add_cart)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_boards,viewGroup,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listBoard.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val board = listBoard[position]
        Glide.with(holder.itemView.context)
            .load(board.photo)
            .apply(RequestOptions().override(55,55))
            .into(holder.tvBoardPhoto)

        holder.tvBoardBrand.text = board.brand
        holder.tvBoardPrice.text = board.price
        holder.tvBoardModel.text = board.model
        holder.tvBoardSize.text = board.size

        holder.btnCart.setOnClickListener{Toast.makeText(holder.itemView.context,listBoard[holder.adapterPosition].model+" added to Cart!",Toast.LENGTH_SHORT).show()}
        holder.btnDetails.setOnClickListener{
            val context = holder.btnDetails.context
            val boardDetailActivity = Intent(context,BoardDetail::class.java)
            boardDetailActivity.putExtra(BoardDetail.EXTRA_BRAND,board.brand)
            boardDetailActivity.putExtra(BoardDetail.EXTRA_PICTURE,board.photo)

            context.startActivity(boardDetailActivity)
        }
    }
}