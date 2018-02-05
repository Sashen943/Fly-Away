package za.co.dvt.spillay.flyaway.ViewModel.AddFlight.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data.Flight;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.repository.FlightRepository;

/**
 * Created by SPillay on 2018/02/05.
 */

public class FlightViewModel extends AndroidViewModel
{
    private FlightRepository flightRepository;
    private LiveData < List < Flight > > flights;

    //constructor
    public FlightViewModel( Application application )
    {
        super(application);
        flightRepository = new FlightRepository(application);
        flights = flightRepository.getAllFlights();
    }

    //get all fights
    public LiveData< List < Flight > > getFlights()
    {
        return flights;
    }

    public void insert(Flight flight)
    {
        flightRepository.insert(flight);
    }




}
