package com.example.recyclerviewexample_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SampleAdapter(private val sampleList:List<SampleItem>):RecyclerView.Adapter<SampleAdapter.SampleViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.sample_item,parent,false)
        return SampleViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
        val curentItem = sampleList[position]

        holder.imageView.setImageResource(curentItem.imageResource)
        holder.textView1.text = curentItem.text1
        holder.textView2.text = curentItem.text2
        holder.textView3.text = curentItem.txt3
    }

    override fun getItemCount()=sampleList.size


    class SampleViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val imageView:ImageView = itemView.findViewById(R.id.img_view);
        val textView1:TextView = itemView.findViewById(R.id.textView_item);
        val textView2:TextView = itemView.findViewById(R.id.textView_description);
        val textView3:TextView = itemView.findViewById(R.id.textView_price);

    }

}




