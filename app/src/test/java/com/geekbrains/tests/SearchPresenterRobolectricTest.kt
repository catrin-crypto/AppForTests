package com.geekbrains.tests

import android.content.Context
import android.os.Build
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.geekbrains.tests.presenter.details.DetailsPresenter
import com.geekbrains.tests.presenter.search.SearchPresenter
import com.geekbrains.tests.view.details.DetailsActivity
import com.geekbrains.tests.view.search.MainActivity
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class SearchPresenterRobolectricTest {
//    private lateinit var scenario: ActivityScenario<MainActivity>
//    private lateinit var context: Context
//
//    @Before
//    fun setUp() {
//        scenario = ActivityScenario.launch(MainActivity::class.java)
//        context = ApplicationProvider.getApplicationContext()
//    }
//    @Test
//    fun activityIsCreated_PresenterIsAttached(){
//        scenario.moveToState(Lifecycle.State.CREATED)
//        testViewToPresenterView()
//    }
//
//    @Test
//    fun activityIsResumed_PresenterIsAttached(){
//        scenario.moveToState(Lifecycle.State.RESUMED)
//        testViewToPresenterView()
//    }
//    @Test
//    fun activityIsDestroyed_PresenterIsDetached(){
//     //   scenario.moveToState(Lifecycle.State.DESTROYED)
//        val testActivity: MainActivity =
//            Robolectric.buildActivity(MainActivity::class.java).create().start().resume().pause().destroy()
//                .get()
//        val presenterView = (testActivity.getPresenter() as SearchPresenter).getView()
//        Assert.assertNull("presenterView when activity is destroyed", presenterView)
//    }
//
//    fun testViewToPresenterView() {
//        scenario.onActivity {
//            val view = it.findViewById<View>(R.id.mainActivityView)
//            val presenterView = (it.getPresenter() as SearchPresenter).getView()
//            Assert.assertNotNull("View", view)
//            Assert.assertEquals("Activity view to presenterView", view, presenterView)
//        }
//    }
//
//    @After
//    fun close() {
//        scenario.close()
//    }
}