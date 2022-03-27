package com.geekbrains.tests

import com.geekbrains.tests.presenter.details.DetailsPresenter
import com.geekbrains.tests.view.details.ViewDetailsContract
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class DetailsPresenterTest {
    private lateinit var presenter: DetailsPresenter
    @Mock
    private lateinit var viewContract : ViewDetailsContract

@Before
fun setUp(){
    MockitoAnnotations.initMocks(this)
    presenter = DetailsPresenter(viewContract,10)
}
    @Test
    fun onIncrementTest(){
        var increasedCount = presenter.count + 1;
        Assert.assertEquals( presenter.apply { onIncrement()}.count,increasedCount)
        println(increasedCount)
    }
    @Test
    fun onDecrementTest(){
        var dereasedCount = presenter.count - 1;
        Assert.assertEquals( presenter.apply { onDecrement()}.count,dereasedCount)
        println(dereasedCount)
    }
}