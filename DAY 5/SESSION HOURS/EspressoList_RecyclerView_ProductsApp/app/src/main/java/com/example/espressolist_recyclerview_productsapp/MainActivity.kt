package com.example.espressolist_recyclerview_productsapp

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


/**
 * Shows a list using a RecyclerView.
 */
class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create a RecyclerView, a LayoutManager, a data Adapter and wire everything up.
        val recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        val dataSet: MutableList<String> = ArrayList(DATASET_COUNT)
        for (i in 0 until DATASET_COUNT) {
            dataSet.add(getString(R.string.item_element_text) + i)
        }
        val adapter = CustomAdapter(dataSet, applicationContext)
        recyclerView.adapter = adapter
    }

    companion object {
        private const val DATASET_COUNT = 50
    }
}