package com.geekbrains.tests

import android.content.Context
import android.os.Build
import android.widget.EditText
import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.geekbrains.tests.view.search.MainActivity
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class MainActivityRobolectricTest {
    private lateinit var scenario: ActivityScenario<MainActivity>
    private lateinit var context: Context

    @Before
    fun setUp() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
        context = ApplicationProvider.getApplicationContext()
    }
    @Test
    fun editTextView_NotNull(){
        scenario.onActivity {
            val editText = it.findViewById<EditText>(R.id.searchEditText)
            editText.setText("some text", TextView.BufferType.EDITABLE)
            Assert.assertNotNull(editText.text)
        }
    }

    @After
    fun close(){
        scenario.close()
    }
}