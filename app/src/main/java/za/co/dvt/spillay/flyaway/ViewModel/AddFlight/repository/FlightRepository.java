package za.co.dvt.spillay.flyaway.ViewModel.AddFlight.repository;

import android.arch.lifecycle.LiveData;

import java.util.List;

import io.reactivex.Completable;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data.Flight;


public interface FlightRepository {

    LiveData<List<Flight>> getListFlights();

    LiveData<Flight> getFlight(int flightId);

    Completable insertFlight(Flight flight);

}
