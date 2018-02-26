package za.co.dvt.spillay.flyaway.data.data.presentation;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import za.co.dvt.spillay.flyaway.R;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.presentation.flight.add.AddFlightActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;

/**
 * @author SPillay
 */
@RunWith(AndroidJUnit4.class)
public class AddFlightActivityTest {

    @Rule
    public ActivityTestRule<AddFlightActivity> mActivityTestRule = new ActivityTestRule<>(AddFlightActivity.class);

    @Test
    public void addFlightButtonClickTest() {
        onView(ViewMatchers.withId(R.id.add_button)).perform(click());
    }

    @Test
    public void cancelButtonClickTest() {
        onView(ViewMatchers.withId(R.id.back_button)).perform(click());
        //  check(ma)
    }

    @Test
    public void datePickerButtonClickTest() {
        onView(ViewMatchers.withId(R.id.button_date)).perform(click());
    }

    @Test
    public void timePickerButtonClickTest() {
        onView(ViewMatchers.withId(R.id.button_time)).perform(click());
    }
}
