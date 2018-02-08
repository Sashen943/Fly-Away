package za.co.dvt.spillay.flyaway.ViewModel.AddFlight.repository;

import android.os.AsyncTask;

import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data.Flight;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data.FlightDao;

public class AddFlightAsyncTask extends AsyncTask<Void, Void, Void> {
    private FlightDao flightDao;
    private Flight flight;

    public AddFlightAsyncTask(FlightDao flightDao, Flight flight) {
        this.flightDao = flightDao;
        this.flight = flight;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        flightDao.insert(flight);
        return null;
    }
}
