package com.example.pil_mobile_basics.mvp.project.presenter

import com.example.pil_mobile_basics.mvp.project.contract.CounterContract
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class CounterPresenterTest {
    private lateinit var counterPresenter: CounterContract.Presenter

    @MockK
    private lateinit var counterView: CounterContract.View

    @MockK
    private lateinit var counterModel: CounterContract.Model

    @Before
    fun onBefore(){
        MockKAnnotations.init(this, relaxed = true)
        counterPresenter = CounterPresenter(counterModel, counterView)
    }

    //true branch increase button
    @Test
    fun `If in the increase button there is an empty input should show an error message`(){
        every { counterView.validateInput() } returns true
        counterPresenter.onIncreaseButtonPressed()
        verify { counterView.showError() }
    }

    //false branch increase button
    @Test
    fun `If in the increase button there is an input I should to get a count`(){
        every { counterView.validateInput() } returns false
        counterPresenter.onIncreaseButtonPressed()
        verify { counterView.getInput() }
    }

    //true branch decrement button
    @Test
    fun `If in the decrement button there is an empty input should show an error message`(){
        every { counterView.validateInput() } returns true
        counterPresenter.onDecrementButtonPressed()
        verify { counterView.showError() }
    }

    //false branch decrement button
    @Test
    fun `If in the decrement button there is a input I should to get a count`(){
        every { counterView.validateInput() } returns false
        counterPresenter.onDecrementButtonPressed()
        verify { counterView.getInput() }
    }

    //Reset button
    @Test
    fun `If I enter to reset button the count should be zero`(){
        val resetValue = "0"
        every { counterView.onResetButtonPressed { counterView.setCount(resetValue) } } returns counterView.setCount(resetValue)
        counterPresenter.onResetButtonPressed()
        verify { counterView.setCount(resetValue) }
    }
}