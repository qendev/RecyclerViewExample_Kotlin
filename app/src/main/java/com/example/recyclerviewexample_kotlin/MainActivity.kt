package com.example.recyclerviewexample_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val sampleList = generateDummyList(101)

    private  val adapter = SampleAdapter(sampleList)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        my_recyclerview.adapter = adapter
        my_recyclerview.layoutManager = LinearLayoutManager(this)
        my_recyclerview.setHasFixedSize(true)
    }
    private fun generateDummyList(size:Int): ArrayList<SampleItem>{
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

    fun addItem(view: View) {
        val index:Int = Random.nextInt(8)

        val newItem = SampleItem(
            R.drawable.ic_android,
            "New Item at Position $index",
            "Description",
            "Price"

        )
        sampleList.add(index, newItem)
        adapter.notifyItemInserted(index)

    }

    fun removeItem(view: View) {
        val index:Int = Random.nextInt(8)
        sampleList.removeAt(index)
        adapter.notifyItemRemoved(index)

    }
}