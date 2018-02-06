package za.co.dvt.spillay.flyaway.ViewModel.AddFlight.presentation.flight.add;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.Injection;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data.Flight;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.repository.FlightRepository;

/**
 * Created by SPillay on 2018/02/06.
 */

public class AddFlightViewModel extends AndroidViewModel {

    private FlightRepository flightRepository;

    public AddFlightViewModel(@NonNull Application application) {
        super(application);
        flightRepository = Injection.getFlightRepositoryInstance(application);
    }

    public void saveFlight(String refrenceNumber, String time, String date, String to, String from)
    {
        Flight flight = new Flight( refrenceNumber , date , time , from , to );

        flightRepository.insertFlight(flight);
    }
}
