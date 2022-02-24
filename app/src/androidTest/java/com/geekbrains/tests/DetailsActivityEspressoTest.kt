package com.geekbrains.tests

import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.geekbrains.tests.view.details.DetailsActivity
import junit.framework.TestCase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DetailsActivityEspressoTest {
    private lateinit var scenario : ActivityScenario<DetailsActivity>
@Before
fun setUp(){
    scenario = ActivityScenario.launch(DetailsActivity::class.java)
}
    @Test
    fun activity_AssertNotNull(){
        scenario.onActivity {
            TestCase.assertNotNull(it)
        }
    }
    @Test
    fun activity_IsResumed(){
        TestCase.assertEquals(Lifecycle.State.RESUMED, scenario.state)
    }
    @Test
    fun textView_NotNull(){
        scenario.onActivity {
            val totalCountTV = it.findViewById<TextView>(R.id.totalCountTextView)
            TestCase.assertNotNull(totalCountTV)
        }
    }
    @Test
    fun textView_HasText(){
        val assertion : ViewAssertion = matches(withText("Number of results : 0"))
        onView(withId(R.id.totalCountTextView)).check(assertion)
    }
    @Test
    fun textView_IsDisplayed(){
        onView(withId(R.id.totalCountTextView)).check(matches(isDisplayed()))
    }
    @Test
    fun buttons_AreEffectiveVisible(){
        onView(withId(R.id.incrementButton)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.decrementButton)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }
    @Test
    fun incrementButton_IsWorking(){
        onView(withId(R.id.incrementButton)).perform(click())
        onView(withId(R.id.totalCountTextView)).check(matches(withText("Number of results : 1")))
    }
    @Test
    fun decrementButton_IsWorking(){
        onView(withId(R.id.decrementButton)).perform(click())
        onView(withId(R.id.totalCountTextView)).check(matches(withText("Number of results : -1")))
    }
    @After
    fun close(){
        scenario.close()
    }
}