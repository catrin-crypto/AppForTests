package com.geekbrains.tests

import android.content.Context
import android.os.Build
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.geekbrains.tests.presenter.details.DetailsPresenter
import com.geekbrains.tests.view.details.DetailsActivity
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class DetailsActivity_PresenterTest {
    private lateinit var scenario: ActivityScenario<DetailsActivity>
    private lateinit var context: Context

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(DetailsActivity::class.java)
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun activityIsCreated_PresenterIsAttached(){
        scenario.moveToState(Lifecycle.State.CREATED)
        testViewToPresenterView()
    }

    @Test
    fun activityIsResumed_PresenterIsAttached(){
        scenario.moveToState(Lifecycle.State.RESUMED)
        testViewToPresenterView()
    }

    @Test
    fun activityIsDestroyed_PresenterIsDetached(){
        val testActivity: DetailsActivity =
            Robolectric.buildActivity(DetailsActivity::class.java).create().start().resume().pause().destroy()
                .get()
            val presenterView = (testActivity.getPresenter() as DetailsPresenter).getView()
            Assert.assertNull("presenterView when activity is destroyed", presenterView)
    }

    private fun testViewToPresenterView() {
        scenario.onActivity {
            val view = it.findViewById<View>(R.id.mainDetailsView)
            val presenterView = (it.getPresenter() as DetailsPresenter).getView()
            Assert.assertNotNull("View", view)
            Assert.assertEquals("Activity view to presenterView", view, presenterView)
        }
    }

    @After
    fun close() {
        scenario.close()
    }
}