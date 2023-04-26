package com.example.android.register

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith
import register.R

@RunWith(AndroidJUnit4ClassRunner::class)
class NavigationTest {

    @Test
    fun test_Fragments_Navigation_From_Registration_To_Profile_And_Back() {
        //Launch activity scenario
        ActivityScenario.launch(MainActivity::class.java)
        //Type name
        onView(withId(R.id.editTextName)).perform(ViewActions.typeText("John Dumelo"))
        Espresso.closeSoftKeyboard()
        //Type email
        onView(withId(R.id.editTextEmail)).perform(ViewActions.typeText("johndumelo@gmail.com"))
        Espresso.closeSoftKeyboard()
        //Type phone number
        onView(withId(R.id.editTextPhoneNumber)).perform(ViewActions.typeText("+2347039210649"))
        Espresso.closeSoftKeyboard()
        //Click submit button
        onView(withId(R.id.submitButton)).perform(click())
        //Navigate to profile fragment
        onView(withId(R.id.profileFragment)).check(matches(isDisplayed()))
        //Navigate back
        pressBack()
        //verify that registration fragment is in view
        onView(withId(R.id.registrationFragment)).check(matches(isDisplayed()))
    }
}