package za.co.dvt.spillay.flyaway.ViewModel.AddFlight.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data.Flight;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data.FlightDao;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data.FlightRoomDatabase;

/**
 * Created by SPillay on 2018/02/02.
 */

public class FlightRepository
{
   private FlightDao flightDao;
   private LiveData<List<Flight>> flights;

   public FlightRepository(Application application)
   {
       FlightRoomDatabase flightRoomDatabase = FlightRoomDatabase.getDatabase(application);
       this.flightDao = flightRoomDatabase.flightDao();
       this.flights = flightDao.getAllFlights();
   }

   public LiveData<List<Flight>> getAllFlights()
   {
       return flights;
   }

   public void insert(Flight flight)
   {
       new insertAsyncTask(flightDao).execute(flight);
   }

    public static class insertAsyncTask extends AsyncTask< Flight , Void , Void >
    {
        private FlightDao flightDao;

        insertAsyncTask( FlightDao dao )
        {
          flightDao = dao;
        }

        @Override
        protected Void doInBackground( final Flight... params )
        {
           flightDao.insert(params[0]); //may need to be changed
            return null;
        }
    }
}
