package com.example.android.register

import org.junit.Test

import org.junit.Assert.*

class UtilsTest {

    //TESTS FOR NAME VALIDATOR
    @Test
    fun nameValidator_EmptyName_ReturnsFalse() {
        //If name field is empty, return false
        assertFalse(Utils.nameValidator(""))
    }

    @Test
    fun nameValidator_NameNotEmpty_ReturnsTrue() {
        //If name field is not empty, return true
        assertTrue(Utils.nameValidator("John"))
    }


    //TESTS FOR EMAIL VALIDATOR
    @Test
    fun emailValidator_EmptyEmail_ReturnsFalse() {
        //if email is empty, returns false
        assertFalse(Utils.emailValidator(""))
    }

    @Test
    fun emailValidator_EmailNotEmpty_ReturnsTrue() {
        //If email is filled, returns true
        assertTrue(Utils.emailValidator("johndoe@gmail.com"))
    }


    //TESTS FOR PHONE NUMBER VALIDATOR
    @Test
    fun phoneNumberValidator_CorrectStartingDigitOfZero_ReturnsTrue(){
        //Phone number can only start with zero for local calls
        assertTrue(Utils.phoneNumberValidator("08089455259"))
    }

    @Test
    fun phoneNumberValidator_IncorrectStartingDigit_ReturnsFalse() {
        //Returns false if phone number starts with any other number apart from zero for local calls
        assertFalse(Utils.phoneNumberValidator("10078365279"))
        assertFalse(Utils.phoneNumberValidator("8089455259"))
    }

    @Test
    fun phoneNumberValidator_CorrectCountryCode_ReturnsTrue() {
        // "+234" is the correct country code
        assertTrue(Utils.phoneNumberValidator("+2347039210649"))
    }

    @Test
    fun phoneNumberValidator_IncorrectCountryCode_ReturnsFalse() {
        //returns false if country code isn't "+234"
        assertFalse(Utils.phoneNumberValidator("+1237039210649"))
    }

    @Test
    fun phoneNumberValidator_ValidSecondDigitFromZero_ReturnsTrue() {
        //valid digits are only 7,8 and 9
        assertTrue(Utils.phoneNumberValidator("07089455259"))
        assertTrue(Utils.phoneNumberValidator("08089455259"))
        assertTrue(Utils.phoneNumberValidator("09089455259"))
    }
    @Test
    fun phoneNumberValidator_InvalidSecondDigitFromZero_ReturnsFalse() {
        //invalid second digits are any digits between 0 and 6 inclusive
        assertFalse(Utils.phoneNumberValidator("00089455259"))
        assertFalse(Utils.phoneNumberValidator("06089455259"))
        assertFalse(Utils.phoneNumberValidator("04189455259"))
    }

    @Test
    fun phoneNumberValidator_ValidSecondDigitFromCountryCode_ReturnsTrue() {
        //valid digits are only 7,8 and 9
        assertTrue(Utils.phoneNumberValidator("+2347089455259"))
        assertTrue(Utils.phoneNumberValidator("+2348089455259"))
        assertTrue(Utils.phoneNumberValidator("+2349089455259"))
    }
    @Test
    fun phoneNumberValidator_InvalidSecondDigitFromCountryCode_ReturnsFalse() {
        //invalid digits are any digits between 0 and 6 inclusive
        assertFalse(Utils.phoneNumberValidator("+23430089455259"))
        assertFalse(Utils.phoneNumberValidator("+2346089455259"))
        assertFalse(Utils.phoneNumberValidator("+2344189455259"))
    }

    @Test
    fun phoneNumberValidator_ValidThirdDigitFromZeroOrCountryCode_ReturnsTrue() {
        //Third digit can only be 0 or 1
        assertTrue(Utils.phoneNumberValidator("07078365279"))
        assertTrue(Utils.phoneNumberValidator("+2348145525912"))
    }

    @Test
    fun phoneNumberValidator_InvalidThirdDigitFromZeroOrCountryCode_ReturnsFalse() {
        //Will return false for any third digit that is not 0 or 1
        assertFalse(Utils.phoneNumberValidator("07778365279"))
        assertFalse(Utils.phoneNumberValidator("+2348245525986"))
    }

    @Test
    fun phoneNumberValidator_ValidNumberOfDigits_ReturnsTrue() {
        //Total number of digits can only be 13 for countryCode format and 11 for local calls format
        assertTrue(Utils.phoneNumberValidator("08089455259"))
        assertTrue(Utils.phoneNumberValidator("+2348089455259"))
    }

    @Test
    fun phoneNumberValidator_InvalidNumberOfDigits_ReturnsFalse() {
        //returns false if total number of digits is greater or less than 13 for countryCode format and
        // greater than or less than 11 for local calls format
        assertFalse(Utils.phoneNumberValidator("08089455"))
        assertFalse(Utils.phoneNumberValidator("+2348089455259265"))
    }


}