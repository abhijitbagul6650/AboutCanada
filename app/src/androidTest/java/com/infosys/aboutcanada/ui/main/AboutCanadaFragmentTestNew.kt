package com.infosys.aboutcanada.ui.main

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.runner.AndroidJUnit4
import com.infosys.aboutcanada.R
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class AboutCanadaFragmentTestNew {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    //FOR TESTING FRAGMENT LOADED IN CONTAINER
    @Test
    fun switchToFragment() {
        onView(withId(R.id.container)).check(matches(isDisplayed()))
    }

    //FOR TESTING LIST ITEMS ARE DISPLAYING
    @Test
    fun fragmentLaunchTest() {
        onView(withId(R.id.rvAboutCanada))
            .check(matches(isDisplayed()))
    }
}