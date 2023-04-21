package com.example.customviewmatcher


import android.content.res.Resources.NotFoundException
import android.view.View
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers

/**
 * Matchers to assert the contents of TextView error texts.
 */
object ErrorTextMatchers {
    /**
     * Returns a matcher that matches [android.widget.TextView]s based on text value.
     *
     * @param text [String] with text to match
     */
    fun withErrorText(text: String): BoundedMatcher<View?, TextView> {
        return withErrorText(Matchers.`is`(text))
    }

    /**
     * Returns a matcher that matches [android.widget.TextView]s based on text property value.
     *
     * @param stringMatcher [Matcher] of [String] with text to match
     */
    fun withErrorText(stringMatcher: Matcher<String>): BoundedMatcher<View?, TextView> {
        return object : BoundedMatcher<View?, TextView>(TextView::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("with error text: ")
                stringMatcher.describeTo(description)
            }

            public override fun matchesSafely(textView: TextView): Boolean {
                return stringMatcher.matches(textView.error.toString())
            }
        }
    }

    /**
     * Returns a matcher that matches a descendant of [android.widget.TextView] that is displaying the error
     * string associated with the given resource id.
     *
     * @param resourceId the string resource the text view is expected to hold.
     */
    fun withErrorText(@StringRes resourceId: Int): BoundedMatcher<View?, TextView> {
        return object : BoundedMatcher<View?, TextView>(TextView::class.java) {
            private var resourceName: String? = null
            private var expectedText: String? = null
            override fun describeTo(description: Description) {
                description.appendText("with error text from resource id: ")
                description.appendValue(resourceId)
                if (null != resourceName) {
                    description.appendText("[")
                    description.appendText(resourceName)
                    description.appendText("]")
                }
                if (null != expectedText) {
                    description.appendText(" value: ")
                    description.appendText(expectedText)
                }
            }

            public override fun matchesSafely(textView: TextView): Boolean {
                if (null == expectedText) {
                    try {
                        expectedText = textView.resources.getString(resourceId)
                        resourceName = textView.resources.getResourceEntryName(resourceId)
                    } catch (ignored: NotFoundException) {
                        // view could be from a context unaware of the resource id
                    }
                }
                return null != expectedText && expectedText == textView.error
            }
        }
    }
}