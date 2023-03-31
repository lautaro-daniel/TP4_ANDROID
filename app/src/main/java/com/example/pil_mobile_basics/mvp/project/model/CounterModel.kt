package com.example.pil_mobile_basics.mvp.project.model

import com.example.pil_mobile_basics.mvp.project.contract.CounterContract
import com.example.pil_mobile_basics.mvp.project.model.Constant.ZERO

class CounterModel():CounterContract.Model {

    private var count = ZERO

    override fun count(): String {
        return count.toString()
    }

    override fun increaseCount(value:Int) {
        count += value
    }

    override fun decrementCount(value:Int) {
        count -= value
    }

    override fun resetCount() {
        count = ZERO
    }
}