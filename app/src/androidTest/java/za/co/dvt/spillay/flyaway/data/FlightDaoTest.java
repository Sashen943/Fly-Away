package za.co.dvt.spillay.flyaway.data;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data.Flight;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data.FlightDao;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data.FlightRoomDatabase;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by SPillay on 2018/02/20.
 */

@RunWith(AndroidJUnit4.class)
public class FlightDaoTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private FlightRoomDatabase database;
    private FlightDao flightDao;

    @Before
    public void initDb() throws Exception {
        database = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                FlightRoomDatabase.class)
                .allowMainThreadQueries()
                .build();

        flightDao = database.getFlightDao();
    }

    @After
    public void closeDb() throws Exception {
        database.close();
    }

    @Test
    public void onFetchingFlights_shouldGetEmptyList_ifDatabase_isEmpty() throws InterruptedException {
        List<Flight> flightList = (List<Flight>) flightDao.getAllFlights();
        assertTrue(flightList.isEmpty());
    }

    @Test
    public void onInsertingFlights_checkIf_RowCountIsCorrect() throws InterruptedException {
        final List<Flight> flightList = null;
        flightList.forEach(flight -> {
            flightDao.insert(flight);
        });
        assertEquals(5, LiveDataTestUtil.getValue(flightDao.getAllFlights()).size());
    }
}
