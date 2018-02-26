package za.co.dvt.spillay.flyaway.data.data.presentation;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.presentation.flight.list.FlightListActivity;

/**
 * @author SPillay
 */
@RunWith(AndroidJUnit4.class)
public class SplashScreenActivityTest {
    @Rule
    public ActivityTestRule<FlightListActivity> mActivityTestRule = new ActivityTestRule<>(FlightListActivity.class);

    @Test
    public void fabButtonClickTest() {

    }
}
