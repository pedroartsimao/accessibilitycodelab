package com.psimao.accessibilitycodelab.features.timer

import android.os.Bundle
import android.os.CountDownTimer
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.psimao.accessibilitycodelab.R
import kotlinx.android.synthetic.main.dialog_timer.*
import android.view.Gravity



class TimerDialog : DialogFragment() {

    companion object {
        val EXTRA_SECONDS = "extra_seconds"

        fun newInstance(secs: Int): TimerDialog = TimerDialog().apply {
            arguments = Bundle().apply {
                putInt(EXTRA_SECONDS, secs)
            }
        }
    }

    private val secs by lazy { arguments.getInt(EXTRA_SECONDS, -1) }
    private var timer: CountDownTimer? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.dialog_timer, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (secs >= 0) {
            textViewTimer.text = secs.toString()
            timer = object : CountDownTimer((secs * 1000).toLong(), 1000) {
                override fun onFinish() {
                    textViewTimer.text = getString(R.string.dialog_timer_finished)
                }

                override fun onTick(millisUntilFinished: Long) {
                    textViewTimer.text = ((millisUntilFinished / 1000) + 1).toString()
                }
            }
            timer?.start()
        }
    }

    override fun onResume() {
        super.onResume()
        val window = dialog.window
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        window.setGravity(Gravity.CENTER)
    }

    override fun onDestroyView() {
        timer?.cancel()
        super.onDestroyView()
    }
}
