package com.example.pil_mobile_basics.mvp.project.presenter

import com.example.pil_mobile_basics.mvp.project.contract.CounterContract

class CounterPresenter(private val model : CounterContract.Model, private val view : CounterContract.View) : CounterContract.Presenter {

    init {
        view.onIncreaseButtonPressed{ onIncreaseButtonPressed() }
        view.onDecrementButtonPressed{ onDecrementButtonPressed() }
        view.onResetButtonPressed{ onResetButtonPressed() }
    }


    override fun onIncreaseButtonPressed(){
        if (view.validateInput()){
            view.showError()
        }else{
            model.increaseCount(view.getInput())
            view.setCount(model.count())
        }
    }

    override fun onDecrementButtonPressed(){
        if (view.validateInput()){
            view.showError()
        }else{
            model.decrementCount(view.getInput())
            view.setCount(model.count())
        }
    }

    override fun onResetButtonPressed(){
        if (view.validateCountOnZero()){
            view.showCountAlreadyReset()
        }else {
            model.resetCount()
            view.setCount(model.count())
        }
    }

}