package com.example.pil_mobile_basics.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pil_mobile_basics.R
import com.example.pil_mobile_basics.mvp.project.model.CounterModel
import com.example.pil_mobile_basics.mvp.project.presenter.CounterPresenter
import com.example.pil_mobile_basics.mvp.project.view.CounterView

class MainCounter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CounterPresenter(CounterModel(), CounterView(this))
    }
}