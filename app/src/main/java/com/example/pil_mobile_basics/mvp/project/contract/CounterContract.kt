package com.example.pil_mobile_basics.mvp.project.contract

class CounterContract {
    interface Model{
        fun count():String
        fun increaseCount(value:Int)
        fun decrementCount(value:Int)
        fun resetCount()
        fun validateCountOnZero():Boolean
    }

    interface View{
        fun setCount(number:String)
        fun onIncreaseButtonPressed(onClick:() -> Unit)
        fun onDecrementButtonPressed(onClick:() -> Unit)
        fun onResetButtonPressed(onClick:() -> Unit)
        fun getInput():Int
        fun validateInput():Boolean
        fun showError()
        fun showCountAlreadyReset()
    }

    interface Presenter{
        fun onIncreaseButtonPressed()
        fun onDecrementButtonPressed()
        fun onResetButtonPressed()
    }
}