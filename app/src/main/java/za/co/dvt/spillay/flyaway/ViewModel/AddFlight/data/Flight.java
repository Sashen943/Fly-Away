package za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * @author SPillay
 */
@Entity(tableName = "Flights")
public class Flight {

    @SuppressWarnings("")
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "flightId")
    private int flightId;
    private String referenceNumber;
    private String date;
    private String time;
    private String from;
    private String to;

    //constructor
    public Flight(String referenceNumber, String date, String time, String from, String to) {
        this.referenceNumber = referenceNumber;
        this.date = date;
        this.time = time;
        this.from = from;
        this.to = to;
    }

    //Getters and setters
    public String getReferenceNumber() {
        return referenceNumber;
    }

    public String getDate() {
        return this.date;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return this.to;
    }

    public int getFlightId() {
        return this.flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

}
