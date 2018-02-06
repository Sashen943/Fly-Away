package za.co.dvt.spillay.flyaway.ViewModel.AddFlight;

import android.content.Context;

import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data.FlightRoomDatabase;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.repository.FlightRepository;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.repository.FlightRepositoryImpl;

/**
 * Created by SPillay on 2018/02/06.
 */

public class Injection {

    private static FlightRepository flightRepository = null;

    public static FlightRepository getInstance(final Context context) {
        if (flightRepository == null) {
            synchronized (FlightRepository.class) {
                if (flightRepository == null) {
                    flightRepository = new FlightRepositoryImpl(FlightRoomDatabase.getInstance(context).getFlighDao());
                }
            }
        }
        return flightRepository;
    }

}