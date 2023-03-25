package com.example.pil_mobile_basics.mvp.project.view

import android.app.Activity
import android.widget.Toast
import com.example.pil_mobile_basics.R
import com.example.pil_mobile_basics.databinding.ActivityMainBinding
import com.example.pil_mobile_basics.mvp.project.contract.CounterContract

class CounterView(activity: Activity): ActivityView(activity), CounterContract.View {

    private var binding : ActivityMainBinding = ActivityMainBinding.inflate(activity.layoutInflater)

    init {
        activity.setContentView(binding.root)
    }
    override fun setCount(number: String) {
        binding.counterValue.text = number
    }

    override fun onIncreaseButtonPressed(onClick: () -> Unit) {
        binding.increaseButton.setOnClickListener { onClick() }
    }

    override fun onDecrementButtonPressed(onClick: () -> Unit) {
        binding.decrementButton.setOnClickListener { onClick() }
    }

    override fun onResetButtonPressed(onClick: () -> Unit) {
        binding.resetButton.setOnClickListener { onClick() }
    }

    override fun getInput(): Int {
        return binding.numberInput.text.toString().toInt()
    }

    override fun validateInput():Boolean{
        return binding.numberInput.text.isEmpty()
    }
    override fun showError() {
        Toast.makeText(activity, activity?.resources?.getString(R.string.empty_error), Toast.LENGTH_SHORT).show()
    }

}