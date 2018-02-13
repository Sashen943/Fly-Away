package za.co.dvt.spillay.flyaway.ViewModel.AddFlight.repository;

import android.os.AsyncTask;

import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data.Flight;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data.FlightDao;

/**
 * Created by SPillay on 2018/02/13.
 */

public class GetFlightAsyncTask extends AsyncTask<Void, Void, Flight> {

    FlightDao flightDao;
    Flight flight;
    int flightId;
    FlightRepository.RepositoryCallback callback;

    public GetFlightAsyncTask(int flightId, FlightDao flightDao, FlightRepository.RepositoryCallback callback) {
        this.flightDao = flightDao;
        this.flightId = flightId;
        this.callback = callback;
    }

    @Override
    protected Flight doInBackground(Void... voids) {
        flight = flightDao.getFlightDetails(flightId);
        return flight;
    }

    @Override
    protected void onPostExecute(Flight flight) {
        super.onPostExecute(flight);
        if (callback != null) {
            callback.onFlightLoaded(flight);
        } else {
            callback.onError(null);
        }
    }
}
