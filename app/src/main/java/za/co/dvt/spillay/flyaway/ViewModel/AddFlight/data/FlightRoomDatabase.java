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

    public abstract FlightDao getFlighDao();

    private static FlightRoomDatabase sInstance;

    public static FlightRoomDatabase getInstance(final Context context) {
        if (sInstance == null) {
            synchronized (FlightRoomDatabase.class) {
                if (sInstance == null) {
                    sInstance = buildDatabase(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    private static FlightRoomDatabase buildDatabase(final Context appContext) {
        return Room.databaseBuilder(appContext, FlightRoomDatabase.class, "recipes_db").build();
    }
}
