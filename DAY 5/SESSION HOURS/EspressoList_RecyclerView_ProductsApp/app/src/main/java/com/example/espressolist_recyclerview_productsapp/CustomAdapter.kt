package com.example.espressolist_recyclerview_productsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


/**
 * Provides views to [RecyclerView] with data from a data set.
 */
class CustomAdapter
/**
 * Initialize the dataset of the Adapter.
 *
 * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
 */ internal constructor(private val mDataSet: List<String>, private val mContext: Context) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    /**
     * Provide a reference to the type of views that you are using
     * (custom [RecyclerView.ViewHolder]).
     */
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val textView: TextView

        // We'll use this field to showcase matching the holder from the test.
        var isInTheMiddle = false

        init {
            textView = v.findViewById<View>(R.id.textView) as TextView
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view.
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.text_row_item, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        if (position == mDataSet.size / 2 /* calculate middle element position */) {
            viewHolder.isInTheMiddle = true
            viewHolder.textView.text = mContext.resources.getString(R.string.middle)
        } else {
            viewHolder.isInTheMiddle = false
            viewHolder.textView.text = mDataSet[position]
        }
    }

    // Return the size of your data set (invoked by the layout manager)
    override fun getItemCount(): Int {
        return mDataSet.size
    }
}
