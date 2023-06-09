package com.example.espressolist_fruitapp


import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.startsWith
import org.hamcrest.Matchers.instanceOf
import org.hamcrest.core.AllOf.allOf
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    var mActivityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.espressolist_fruitapp", appContext.packageName)
    }

    @Test
    fun listView_isCorrect() {
        // check list view is visible
        onView(withId(R.id.listView)).check(matches(isDisplayed()))
        onData(allOf(`is`(instanceOf(String::class.java)), startsWith("Apple"))).perform(click())
        onData(allOf(`is`(instanceOf(String::class.java)), startsWith("Apple")))
            .check(matches(withText("Apple")))
        // click a child item
        onData(allOf())
            .inAdapterView(withId(R.id.listView))
            .atPosition(10)
            .perform(click())
    }

}