package za.co.dvt.spillay.flyaway.ViewModel.AddFlight.repository;

import android.os.AsyncTask;

import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data.Flight;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data.FlightDao;

/**
 * Created by SPillay on 2018/02/06.
 */

public class AddFlightAsyncTask extends AsyncTask<Void, Void, Void>
{
    private FlightDao flightDao;
    private Flight flight;

    public AddFlightAsyncTask(FlightDao recipeDao, Flight flight)
    {
        this.flightDao = flightDao;
        this.flight = flight;
    }

    @Override
    protected Void doInBackground(Void... voids)
    {
        flightDao.insert(flight);
        return null;
    }
}
