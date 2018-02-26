package za.co.dvt.spillay.flyaway.ViewModel.AddFlight.presentation.flight.details;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.Injection;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data.Flight;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.repository.FlightRepository;

/**
 * Created by SPillay on 2018/02/13.
 */

public class FlightDetailsViewModel extends AndroidViewModel {

    FlightRepository flightRepository;
    LiveData<Flight> flight;

    public FlightDetailsViewModel(Application application) {
        super(application);
        flightRepository = Injection.getFlightRepositoryInstance(application);
    }

    public LiveData<Flight> getFlightDetails(int flightId) {
        return flightRepository.getFlight(flightId);
    }

}
