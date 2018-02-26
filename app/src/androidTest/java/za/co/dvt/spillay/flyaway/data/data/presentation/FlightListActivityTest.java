package za.co.dvt.spillay.flyaway.data.data.presentation;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import za.co.dvt.spillay.flyaway.R;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.presentation.flight.list.FlightListActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;

/**
 * @author SPillay
 */
@RunWith(AndroidJUnit4.class)
public class FlightListActivityTest {
    @Rule
    public ActivityTestRule<FlightListActivity> mActivityTestRule = new ActivityTestRule<>(FlightListActivity.class);

    @Test
    public void fabButtonClickTest() {
        onView(ViewMatchers.withId(R.id.fab_add_flight)).perform(click());
    }

    @Test
    public void listItemClickTest() {
        // onView(ViewMatchers.withId(R.layout.list_item)).perform(click());
    }
}
