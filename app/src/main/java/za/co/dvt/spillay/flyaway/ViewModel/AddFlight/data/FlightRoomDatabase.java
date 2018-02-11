package za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Flight.class}, version = 2)
public abstract class FlightRoomDatabase extends RoomDatabase {

    public abstract FlightDao getFlightDao();

    private static FlightRoomDatabase instance;

    public static FlightRoomDatabase getInstance(final Context context) {
        if (instance == null) {
            synchronized (FlightRoomDatabase.class) {
                if (instance == null) {
                    instance = buildDatabase(context.getApplicationContext());
                }
            }
        }
        return instance;
    }

    private static FlightRoomDatabase buildDatabase(final Context appContext) {
        return Room.databaseBuilder(appContext, FlightRoomDatabase.class, "Flights").build();
    }
}
