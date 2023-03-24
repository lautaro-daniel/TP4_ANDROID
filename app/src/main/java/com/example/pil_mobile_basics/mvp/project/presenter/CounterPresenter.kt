package com.example.pil_mobile_basics.mvp.project.presenter

import com.example.pil_mobile_basics.mvp.project.contract.CounterContract

class CounterPresenter(private val model : CounterContract.Model, private val view : CounterContract.View) : CounterContract.Presenter {
    init {
        view.onIncreaseButtonPressed{ onIncreaseButtonPressed() }
        view.onDecrementButtonPressed{ onDecrementButtonPressed() }
        view.onResetButtonPressed{ onResetButtonPressed() }
    }


    override fun onIncreaseButtonPressed(){
        model.increaseCount()
        view.setCount(model.getCount())
    }

    override fun onDecrementButtonPressed(){
        model.decrementCount()
        view.setCount(model.getCount())
    }

    override fun onResetButtonPressed(){
        model.resetCount()
        view.setCount(model.getCount())

    }
}