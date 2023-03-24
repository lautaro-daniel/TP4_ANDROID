package com.example.pil_mobile_basics.mvp.project.model

import com.example.pil_mobile_basics.mvp.project.contract.CounterContract
import com.example.pil_mobile_basics.mvp.project.model.Constant.ZERO

class CounterModel():CounterContract.Model {

    private var count = ZERO

    override fun getCount(): String {
        return count.toString()
    }

    override fun increaseCount() {
        count++
    }

    override fun decrementCount() {
        count--
    }

    override fun resetCount() {
        count = ZERO
    }
}