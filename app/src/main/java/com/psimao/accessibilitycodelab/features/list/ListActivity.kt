package com.psimao.accessibilitycodelab.features.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.psimao.accessibilitycodelab.R
import com.psimao.accessibilitycodelab.extension.generateRandomColor
import com.psimao.accessibilitycodelab.features.detail.DetailActivity
import com.psimao.accessibilitycodelab.model.NumberItem
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        bindRecyclerView()
    }

    private fun bindRecyclerView() {
        recyclerviewNumbers.apply {
            layoutManager = LinearLayoutManager(this@ListActivity)
            adapter = NumberAdapter(populateNumbersList(), {
                startActivity(DetailActivity.createIntent(this@ListActivity, it))
            })
        }
    }

    private fun populateNumbersList(): List<NumberItem> {
        val numbers = ArrayList<NumberItem>()
        for (i in 1..50) {
            val description = "This is number $i!"
            numbers.add(NumberItem(i, description, generateRandomColor()))
        }
        return numbers
    }
}
