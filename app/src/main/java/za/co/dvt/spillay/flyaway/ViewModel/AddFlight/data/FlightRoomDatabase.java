package za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by SPillay on 2018/02/05.
 */

@Database(entities = {Flight.class}, version = 1)
public abstract class FlightRoomDatabase extends RoomDatabase
{

    private static FlightRoomDatabase INSTANCE;

    public abstract FlightDao flightDao();
    public static FlightRoomDatabase getDatabase(final Context context)
    {
        if ( INSTANCE == null )
        {
            synchronized ( FlightRoomDatabase.class )
            {
                if ( INSTANCE == null)
                {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext() , FlightRoomDatabase.class , "Flights" ).build();
                }
            }
        }
        return INSTANCE;
    }

}
