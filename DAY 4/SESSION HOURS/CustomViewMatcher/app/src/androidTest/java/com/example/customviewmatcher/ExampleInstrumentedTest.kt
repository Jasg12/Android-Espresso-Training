package com.example.customviewmatcher



import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.rule.ActivityTestRule;


/**
 * Example tests using the [ErrorTextMatchers] class to match error texts.
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class ExampleInstrumentedTest {
    @get:Rule
    var mActivityRule: ActivityTestRule<MainActivity
            > = ActivityTestRule(MainActivity::class.java)
    @Test
    fun checkWithRawText() {
        Espresso
            .onView(ViewMatchers.withId(R.id.email_sign_in_button))
            .perform(ViewActions.click())
        Espresso
            .onView(ViewMatchers.withId(R.id.email))
            .check(ViewAssertions.matches(ErrorTextMatchers.withErrorText("This field is required")))
    }

    @Test
    fun checkWithStringId() {
        Espresso
            .onView(ViewMatchers.withId(R.id.email))
            .perform(ViewActions.typeText("invalid"))
        Espresso
            .onView(ViewMatchers.withId(R.id.email_sign_in_button))
            .perform(ViewActions.click())
        Espresso
            .onView(ViewMatchers.withId(R.id.email))
            .check(ViewAssertions.matches(ErrorTextMatchers.withErrorText(R.string.error_invalid_email)))
    }

    @Test
    fun checkWithMatcher() {
        Espresso
            .onView(ViewMatchers.withId(R.id.email))
            .perform(ViewActions.typeText("user@example.com"))
        Espresso
            .onView(ViewMatchers.withId(R.id.password))
            .perform(ViewActions.typeText("foo"))
        Espresso
            .onView(ViewMatchers.withId(R.id.email_sign_in_button))
            .perform(ViewActions.click())
        Espresso
            .onView(ViewMatchers.withId(R.id.password))
            .check(ViewAssertions.matches(ErrorTextMatchers.withErrorText(Matchers.containsString("too short"))))
    }
}