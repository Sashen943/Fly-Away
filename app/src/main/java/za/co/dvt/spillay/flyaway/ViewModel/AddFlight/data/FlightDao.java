package za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface FlightDao {
    @Insert
    void insert(Flight flight);

    @Query("SELECT * FROM Flights ORDER BY FlightId DESC")
    LiveData<List<Flight>> getAllFlights();

    @Query("SELECT * FROM Flights WHERE flightId=:flightId")
    Flight getFlightDetails(int flightId);
}
