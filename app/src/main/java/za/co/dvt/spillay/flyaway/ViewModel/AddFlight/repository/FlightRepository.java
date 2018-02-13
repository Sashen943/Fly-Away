package za.co.dvt.spillay.flyaway.ViewModel.AddFlight.repository;

import android.arch.lifecycle.LiveData;

import java.util.List;

import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data.Flight;


public interface FlightRepository {

    LiveData<List<Flight>> getListFlights();

    void getFlight(int flightId, RepositoryCallback repositoryCallback);

    void insertFlight(Flight flight);

    interface RepositoryCallback {
        void onFlightLoaded(Flight flight);

        void onError(Exception e);
    }
}
