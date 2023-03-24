package com.example.pil_mobile_basics.mvp.project.contract

class CounterContract {
    interface Model{
        fun getCount():String
        fun increaseCount()
        fun decrementCount()
        fun resetCount()
    }

    interface View{
        fun setCount(number:String)
        fun onIncreaseButtonPressed(function:() -> Unit)
        fun onDecrementButtonPressed(function:() -> Unit)
        fun onResetButtonPressed(function:() -> Unit)
        fun getInput():Int
    }

    interface Presenter{
        fun onIncreaseButtonPressed()
        fun onDecrementButtonPressed()
        fun onResetButtonPressed()
    }
}