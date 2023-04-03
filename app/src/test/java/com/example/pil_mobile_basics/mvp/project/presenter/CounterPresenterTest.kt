package com.example.pil_mobile_basics.mvp.project.presenter

import com.example.pil_mobile_basics.mvp.project.contract.CounterContract
import com.example.pil_mobile_basics.mvp.project.model.Constant.ZERO
import com.example.pil_mobile_basics.mvp.project.model.CounterModel
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

    private var counterModel = CounterModel()

    private val zero = ZERO

    //TESTS
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

    //true branch reset button
    @Test
    fun `If I enter to reset button when the count is already zero should show an message`(){
        every { counterView.validateCountOnZero() } returns true
        counterPresenter.onResetButtonPressed()
        verify { counterView.showCountAlreadyReset() }
    }

    //false branch reset button
    @Test
    //fix this test
    fun `If I enter to reset button should to reset count `(){
        every { counterView.validateCountOnZero() } returns false
        counterPresenter.onResetButtonPressed()
        verify { counterView.setCount(zero.toString())}
    }
}