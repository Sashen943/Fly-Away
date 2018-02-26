package za.co.dvt.spillay.flyaway.ViewModel.AddFlight.presentation.flight.details;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import za.co.dvt.spillay.flyaway.R;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data.Flight;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.presentation.flight.list.FlightListActivity;

/**
 * @author SPillay
 */

public class FlightDetailsActivity extends AppCompatActivity {
    TextView referenceNumberTextView, fromTextView, toTextView, dateTextView, timeTextView;
    Button backButton;
    FlightDetailsViewModel flightDetailsViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_detail);
        initializeUI();
        setClickListener();
        setupViewModel();
    }

    //Initialize UI components
    public void initializeUI() {
        referenceNumberTextView = findViewById(R.id.flight_reference_number_textview);
        fromTextView = findViewById(R.id.flight_from_textview);
        toTextView = findViewById(R.id.flight_to_textview);
        dateTextView = findViewById(R.id.flight_date_textview);
        timeTextView = findViewById(R.id.flight_time_textview);
        backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FlightDetailsActivity.this, FlightListActivity.class));
            }
        });
    }

    //Listen for back button click
    public void setClickListener() {
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FlightDetailsActivity.this, FlightListActivity.class));
            }
        });
    }

    //Sets up view model
    public void setupViewModel() {
        flightDetailsViewModel = ViewModelProviders.of(this).get(FlightDetailsViewModel.class);
        flightDetailsViewModel.getFlightDetails(getFlightId()).observe(this, new Observer<Flight>() {
            @Override
            public void onChanged(@Nullable Flight flight) {
                Log.d("onChanged:", "Flight: " + (flight != null ? flight.getReferenceNumber() : null));
                referenceNumberTextView.setText(flight != null ? flight.getReferenceNumber() : null);
                timeTextView.setText(flight.getTime());
                toTextView.setText(flight.getTo());
                fromTextView.setText(flight.getFrom());
                dateTextView.setText(flight.getDate());
            }
        });
    }

    //gets flight id from previous activity
    public int getFlightId() {
        Bundle extras = getIntent().getExtras();
        return Integer.parseInt(extras.getString("FLIGHT_ID"));
    }


}
