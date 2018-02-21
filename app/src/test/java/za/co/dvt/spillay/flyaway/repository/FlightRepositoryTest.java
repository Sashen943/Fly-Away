package za.co.dvt.spillay.flyaway.repository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data.Flight;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.repository.FlightRepository;

import static org.mockito.Mockito.verify;

/**
 * Created by SPillay on 2018/02/20.
 */

public class FlightRepositoryTest {

    @Mock
    private FlightRepository mockRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInsert() {
        Flight mockFlight = new Flight("#HGFRTY", "12/12/2018", "13:00", "Johannesburg", "Durban");
        mockRepository.insertFlight(mockFlight);
        verify(mockRepository).insertFlight(mockFlight);
    }
}
