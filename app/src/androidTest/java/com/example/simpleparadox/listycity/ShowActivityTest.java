package com.example.simpleparadox.listycity;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import android.app.Activity;
import android.widget.EditText;
import android.widget.ListView;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.robotium.solo.Solo;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test class for MainActivity. All the UI tests are written here. Robotium test framework is used
 */
@RunWith(AndroidJUnit4.class)
public class ShowActivityTest {

    private Solo solo;

    @Rule
    public ActivityTestRule<ShowActivity> rule =
            new ActivityTestRule<>(ShowActivity.class, true, true);
    /**
     * Runs before all tests and creates solo instance.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception{

        solo = new Solo(InstrumentationRegistry.getInstrumentation(),rule.getActivity());
    }
    /**
     * Gets the Activity
     * @throws Exception
     */
    @Test
    public void start() throws Exception{
        Activity activity = rule.getActivity();
    }
    /**
     * checking the functionallity of the button to change the activity
     */
    @Test
    public void checkButton(){
        // Asserts that the current activity is the Show Activity. Otherwise, show “Wrong Activity”
        solo.assertCurrentActivity("Wrong Activity", ShowActivity.class);

        solo.clickOnButton("MAIN"); //Click Button

        solo.assertCurrentActivity("Wrong Activity", MainActivity.class);

    }


    /**
     * Close activity after each test
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception{
        solo.finishOpenedActivities();
    }
}