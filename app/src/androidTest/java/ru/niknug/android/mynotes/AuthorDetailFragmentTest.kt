package ru.niknug.android.mynotes

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AuthorDetailFragmentTest {

    private lateinit var scenario: FragmentScenario<AuthorDetailFragment>

    @Before
    fun setUp() {
        scenario = launchFragmentInContainer<AuthorDetailFragment>()
    }

    @After
    fun tearDown() {
        scenario.close()
    }

    @Test
    fun showsDostoevskyLastName() {
        Espresso.onView(withId(R.id.author_name_edit_text))
            .check(ViewAssertions.matches(withText("Dostoevsky")))
    }


}