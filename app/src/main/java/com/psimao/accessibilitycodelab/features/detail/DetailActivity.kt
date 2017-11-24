package com.psimao.accessibilitycodelab.features.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.psimao.accessibilitycodelab.R
import com.psimao.accessibilitycodelab.features.timer.TimerDialog
import com.psimao.accessibilitycodelab.model.NumberItem
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        private val EXTRA_NUMBER_ITEM = "extra_number_item"

        fun createIntent(context: Context, numberItem: NumberItem): Intent = with(Intent(context, DetailActivity::class.java)) {
            putExtra(EXTRA_NUMBER_ITEM, numberItem)
            return this
        }
    }

    private val numberItem by lazy { intent.getSerializableExtra(EXTRA_NUMBER_ITEM) as NumberItem }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = numberItem.number.toString()

        appBar.setBackgroundColor(numberItem.color)
        textViewDescription.text = getString(R.string.detail_description,
                numberItem.description,
                numberItem.number.toString())

        fab.setOnClickListener {
            TimerDialog.newInstance(numberItem.number).show(supportFragmentManager, null)
        }
    }
}
