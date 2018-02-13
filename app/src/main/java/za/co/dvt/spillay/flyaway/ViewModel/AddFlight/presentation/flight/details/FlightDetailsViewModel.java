package za.co.dvt.spillay.flyaway.ViewModel.AddFlight.presentation.flight.details;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;

import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.Injection;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data.Flight;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.repository.FlightRepository;

/**
 * Created by SPillay on 2018/02/13.
 */

public class FlightDetailsViewModel extends AndroidViewModel {

    FlightRepository flightRepository;
    MutableLiveData<Flight> flight = new MutableLiveData<>();

    public FlightDetailsViewModel(Application application) {
        super(application);
        flightRepository = Injection.getFlightRepositoryInstance(application);
    }

    public void getFlightDetails(int flightId) {
        flightRepository.getFlight(flightId, new FlightRepository.RepositoryCallback() {
            @Override
            public void onFlightLoaded(Flight loadedFlight) {
                flight.postValue(loadedFlight);
            }

            @Override
            public void onError(Exception e) {

            }
        });

    }
}
