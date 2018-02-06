package za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by SPillay on 2018/02/05.
 */
@Entity(tableName = "Flights")
public class Flight
{
    @PrimaryKey ( autoGenerate = true )
    @NonNull
    @ColumnInfo ( name = "FlightId" )
    private int FlightId;

    @ColumnInfo ( name = "Reference_Number" )
    private String refrenceNumber;

    @ColumnInfo( name = "Date" )
    private String Date;

    @ColumnInfo( name = "Time" )
    private String Time;

    @ColumnInfo( name = "From")
    private String From;

    @ColumnInfo( name = "To" )
    private String To;

    //constructor
    public Flight( String refrenceNumber , String Date , String Time , String From , String To )
    {
        this.refrenceNumber = refrenceNumber;
        this.Date = Date;
        this.Time = Time;
        this.From = From;
        this.To = To;
    }

    //Getters and setters
    public String getRefrenceNumber()
    {
        return refrenceNumber;
    }

    public void setRefrenceNumber( String refrenceNumber )
    {
        this.refrenceNumber = refrenceNumber;
    }

    public String getDate()
    {
        return Date;
    }

    public void setDate( String date )
    {
        Date = date;
    }

    public String getTime()
    {
        return Time;
    }

    public void setTime( String time )
    {
        Time = time;
    }

    public String getFrom()
    {
        return From;
    }

    public void setFrom( String from )
    {
        From = from;
    }

    public String getTo()
    {
        return To;
    }

    public void setTo( String to )
    {
        To = to;
    }

    @NonNull
    public int getFlightId()
    {
        return FlightId;
    }

    public void setFlightId( @NonNull int flightId )
    {
        FlightId = flightId;
    }
}
