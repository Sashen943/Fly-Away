package za.co.dvt.spillay.flyaway.ViewModel.AddFlight.presentation.flight.add;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import za.co.dvt.spillay.flyaway.R;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.presentation.flight.list.FlightListActivity;

public class AddFlight extends AppCompatActivity {

    TextView toTextView, fromTextView, dateTextView, timeTextView, refrenceNumberTextView;
    Button addButton, backButton;
    AddFlightViewModel addFlightViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_flight);

        toTextView = findViewById(R.id.txt_flight_to);
        fromTextView = findViewById(R.id.txt_flight_from);
        dateTextView = findViewById(R.id.txt_flight_date);
        timeTextView = findViewById(R.id.txt_flight_time);
        refrenceNumberTextView = findViewById(R.id.txt_flight_reference_number);
        addButton = findViewById(R.id.btn_add);
        backButton = findViewById(R.id.back_button);

        addFlightViewModel = ViewModelProviders.of(this).get(AddFlightViewModel.class);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ref = refrenceNumberTextView.getText().toString();
                String to = toTextView.getText().toString();
                String from = fromTextView.getText().toString();
                String date = dateTextView.getText().toString();
                String time = timeTextView.getText().toString();
                addFlightViewModel.saveFlight(ref, time, date, to, from);
                finish();
                startActivity(new Intent(AddFlight.this, FlightListActivity.class));
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddFlight.this, FlightListActivity.class
                ));
            }
        });

    }
}
