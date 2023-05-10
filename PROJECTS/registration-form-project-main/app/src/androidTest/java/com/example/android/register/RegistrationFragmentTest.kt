package com.example.android.register

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class RegistrationFragmentTest {

    @Test
    fun test_Is_RegistrationFragment_In_View() {
        //Launch registration fragment
        launchFragmentInContainer<RegistrationFragment>(themeResId = R.style.Theme_exampleAndroid007)
        //Verify that registration fragment is displayed
        onView(withId(R.id.registrationFragment)).check(matches(isDisplayed()))
    }

    @Test
    fun test_Is_RegistrationForm_Title_In_View_And_displayed_Correctly() {
        //Launch registration fragment
        launchFragmentInContainer<RegistrationFragment>(themeResId = R.style.Theme_exampleAndroid007)
        //Verify that registration form title is displayed
        onView(withId(R.id.registrationFormTitle)).check(matches(isDisplayed()))
        //Verify that registration form title is the correct text
        onView(withId(R.id.registrationFormTitle)).check(matches(withText(R.string.registration_form_title)))
    }

    @Test
    fun test_Is_name_Input_Field_In_View() {
        //Launch registration fragment
        launchFragmentInContainer<RegistrationFragment>(themeResId = R.style.Theme_exampleAndroid007)
        //Verify that name input field is in view
        onView(withId(R.id.editTextName)).check(matches(isDisplayed()))
    }

    @Test
    fun test_Is_email_Input_Field_In_View() {
        //Launch registration fragment
        launchFragmentInContainer<RegistrationFragment>(themeResId = R.style.Theme_exampleAndroid007)
        //Verify that email input field is in view
        onView(withId(R.id.editTextEmail)).check(matches(isDisplayed()))
    }

    @Test
    fun test_Is_phone_Input_Field_In_View() {
        //Launch registration fragment
        launchFragmentInContainer<RegistrationFragment>(themeResId = R.style.Theme_exampleAndroid007)
        //Verify that phone number input field is in view
        onView(withId(R.id.editTextPhoneNumber)).check(matches(isDisplayed()))
    }

    @Test
    fun test_Is_Submit_button_InView_and_Clickable() {
        //Launch registration fragment
        launchFragmentInContainer<RegistrationFragment>(themeResId = R.style.Theme_exampleAndroid007)
        //Verify that submit button is displayed
        onView(withId(R.id.submitButton)).check(matches(isDisplayed()))
        //Verify that submit button is clickable
        onView(withId(R.id.submitButton)).check(matches(isClickable()))
    }


    @Test
    fun test_UserInput_Scenario() {
        //Launch main activity
        ActivityScenario.launch(MainActivity::class.java)
        //Type name
        onView(withId(R.id.editTextName)).perform(typeText("John Dumelo"))
        closeSoftKeyboard()
        //Type email
        onView(withId(R.id.editTextEmail)).perform(typeText("johndumelo@gmail.com"))
        closeSoftKeyboard()
        //Type phone number
        onView(withId(R.id.editTextPhoneNumber)).perform(typeText("+2347039210649"))
        closeSoftKeyboard()
    }

}