package com.example.android.register

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import register.R
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @get: Rule
    val activityRule : ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)
    //Rule will be called every time a test is run. This saves the stress of manually launching activity
    //inside every test we write

    @Test
    fun test_Is_Activity_In_View() {
        //Verify that main activity is displayed
        onView(withId(R.id.mainActivity)).check(matches(isDisplayed()))
    }

    @Test
    fun test_Is_Fragment_Container_In_View() {
        //Verify that fragment container is in view
        onView(withId(R.id.fragment_container_view)).check(matches(isDisplayed()))
    }
}