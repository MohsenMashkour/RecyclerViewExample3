package com.mkrDeveloper.recyclerviewexample3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val itemsList: List<ItemsData>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_description)
        val imgExpand: ImageView = itemView.findViewById(R.id.img_expand)
        val imgTitle: ImageView = itemView.findViewById(R.id.img_title)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = itemsList[position]


        holder.tvTitle.text = currentItem.title
        holder.tvDescription.text = currentItem.description
        holder.imgTitle.setImageResource(currentItem.image)

        holder.imgExpand.setOnClickListener {

            if (holder.tvDescription.visibility == View.GONE){
                holder.tvDescription.visibility = View.VISIBLE

                holder.imgExpand.setImageResource(R.drawable.ic_close)
            }else{
                holder.tvDescription.visibility = View.GONE

                holder.imgExpand.setImageResource(R.drawable.ic_expand)
            }


        }
    }
}