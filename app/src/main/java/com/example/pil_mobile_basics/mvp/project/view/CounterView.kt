package com.example.pil_mobile_basics.mvp.project.view

import android.app.Activity
import com.example.pil_mobile_basics.mvp.project.contract.CounterContract

class CounterView(activity: Activity): ActivityView(activity), CounterContract.View {

    override fun setCount(number: String) {
        TODO("Not yet implemented")
    }

    override fun onIncreaseButtonPressed(function: () -> Unit) {
        TODO("Not yet implemented")
    }

    override fun onDecrementButtonPressed(function: () -> Unit) {
        TODO("Not yet implemented")
    }

    override fun onResetButtonPressed(function: () -> Unit) {
        TODO("Not yet implemented")
    }

    override fun getInput(): Int {
        TODO("Not yet implemented")
    }

}