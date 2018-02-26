package za.co.dvt.spillay.flyaway.ViewModel.AddFlight.repository;

import android.arch.lifecycle.LiveData;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.functions.Action;
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
    public LiveData<Flight> getFlight(int flightId) {
        return flightDao.getFlightDetails(flightId);
    }

    @Override
    public Completable insertFlight(Flight flight) {
        return Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                flightDao.insert(flight);
            }
        });
    }


}
