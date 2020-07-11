package com.example.recyclerviewexample_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sampleList = generateDummyList(101)
        my_recyclerview.adapter = SampleAdapter(sampleList)
        my_recyclerview.layoutManager = LinearLayoutManager(this)
        my_recyclerview.setHasFixedSize(true)
    }
    private fun generateDummyList(size:Int): List<SampleItem>{
        val list = ArrayList<SampleItem>()
        for (i in 0 until size){
            val drawable = when (i % 3){
                0 -> R.drawable.ic_android
                1 -> R.drawable.ic_audio
                else -> R.drawable.ic_sun
            }
            val item = SampleItem(drawable,"Item $i","Description","Price")
            list += item
        }
        return  list
    }
}