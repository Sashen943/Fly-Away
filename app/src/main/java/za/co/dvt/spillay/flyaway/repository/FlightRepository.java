package za.co.dvt.spillay.flyaway.database.repository;

import java.util.List;

import rx.Observable;
import za.co.dvt.spillay.flyaway.database.Flight;

/**
 * Created by SPillay on 2018/01/29.
 */

public class FlightRepository
{



    public interface UserRepository {

        Observable<List<Flight>> searchUsers(String searchTerm);
    }
}
