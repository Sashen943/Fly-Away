package za.co.dvt.spillay.flyaway.repository.data;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data.Flight;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data.FlightDao;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.repository.FlightRepository;

import static org.mockito.Mockito.verify;

/**
 * Created by SPillay on 2018/02/20.
 */

public class FlightRepositoryTest {

    @Mock
    private FlightDao mockDao;
    @Mock
    private FlightRepository serviceUnderTest;
    Flight mockFlight;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        // serviceUnderTest = new FlightRepository();
        mockFlight = new Flight("#HGFRTY", "12/12/2018", "13:00", "Johannesburg", "Durban");
    }

    @Test
    public void testInsert() {
        serviceUnderTest.insertFlight(mockFlight);
        verify(serviceUnderTest).insertFlight(mockFlight);
    }


}


