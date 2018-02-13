package za.co.dvt.spillay.flyaway.ViewModel.AddFlight.repository;

import android.arch.lifecycle.LiveData;

import java.util.List;

import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data.Flight;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data.FlightDao;

public class FlightRepositoryImpl implements FlightRepository {
    private FlightDao flightDao;

    public FlightRepositoryImpl(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

    @Override
    public LiveData<List<Flight>> getListFlights() {
        return flightDao.getAllFlights();
    }

    @Override
    public void getFlight(int flightId, RepositoryCallback repositoryCallback) {
        new GetFlightAsyncTask(flightId, flightDao, repositoryCallback).execute();
    }

    @Override
    public void insertFlight(Flight flight) {
        new AddFlightAsyncTask(flightDao, flight).execute();
    }
}
