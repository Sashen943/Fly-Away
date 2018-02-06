package za.co.dvt.spillay.flyaway.ViewModel.AddFlight.repository;

import android.arch.lifecycle.LiveData;

import java.util.List;

import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data.Flight;

/**
 * Created by SPillay on 2018/02/02.
 */

public interface FlightRepository {

    LiveData<List<Flight>> getListFlights();

    void insertFlight(Flight flight);
}
