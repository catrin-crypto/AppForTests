package com.geekbrains.tests.espresso

import androidx.core.os.bundleOf
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.geekbrains.tests.R
import com.geekbrains.tests.TEST_NUMBER_OF_RESULTS_MINUS_1
import com.geekbrains.tests.TEST_NUMBER_OF_RESULTS_PLUS_1
import com.geekbrains.tests.view.details.DetailsFragment
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DetailsFragmentEspressoTest {
    private lateinit var scenario : FragmentScenario<DetailsFragment>

    @Before
    fun setup(){
        scenario = launchFragmentInContainer()
    }
@Test
fun bundle_test(){
    val fragmentArgs = bundleOf("TOTAL_COUNT_EXTRA" to 22)
    val scenario = launchFragmentInContainer<DetailsFragment>(fragmentArgs)
    scenario.moveToState(Lifecycle.State.RESUMED)

    val assertion = matches(withText("Number of results: 22"))
    onView(withId(R.id.totalCountTextView)).check(assertion)
}

    @Test
    fun incrementButton_test(){
        onView(withId(R.id.incrementButton)).perform(click())
        onView(withId(R.id.totalCountTextView)).check(matches(withText(TEST_NUMBER_OF_RESULTS_PLUS_1)))
    }

    @Test
    fun decrementButton_test(){
        onView(withId(R.id.decrementButton)).perform(click())
        onView(withId(R.id.totalCountTextView)).check(matches(withText(TEST_NUMBER_OF_RESULTS_MINUS_1)))
    }

    @Test
    fun setCount_test(){
scenario.onFragment{fragment ->
fragment.setCount(111)
}
val assertion = matches(withText("Number of results: 111"))
        onView(withId(R.id.totalCountTextView)).check(assertion)
    }

}