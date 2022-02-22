package com.geekbrains.tests.presenter.details

import android.view.View
import com.geekbrains.tests.view.details.ViewDetailsContract

internal class DetailsPresenter internal constructor(
    private val viewContract: ViewDetailsContract,
    var count: Int = 0
) : PresenterDetailsContract {
    private var presentersView: View? = null

    override fun setCounter(count: Int) {
        this.count = count
    }

    override fun onIncrement() {
        count++
        viewContract.setCount(count)
    }

    override fun onDecrement() {
        count--
        viewContract.setCount(count)
    }

    override fun onAttach(v: View) {
        presentersView = v
    }

    override fun onDetach() {
        presentersView = null
    }
    fun getView(): View? {
        return presentersView
    }
}
