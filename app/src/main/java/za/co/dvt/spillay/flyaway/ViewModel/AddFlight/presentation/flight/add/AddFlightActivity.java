package za.co.dvt.spillay.flyaway.ViewModel.AddFlight.presentation.flight.add;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import za.co.dvt.spillay.flyaway.R;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data.Validation;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.presentation.flight.list.FlightListActivity;

public class AddFlightActivity extends AppCompatActivity {

    TextView toTextView, fromTextView, dateTextView, timeTextView, refrenceNumberTextView, errorTextview;
    Button addButton, backButton;
    AddFlightViewModel addFlightViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_flight);

        refrenceNumberTextView = findViewById(R.id.txt_flight_reference_number);
        toTextView = findViewById(R.id.txt_flight_to);
        fromTextView = findViewById(R.id.txt_flight_from);
        dateTextView = findViewById(R.id.txt_flight_date);
        timeTextView = findViewById(R.id.txt_flight_time);
        errorTextview = findViewById(R.id.errorTextView);
        errorTextview.setVisibility(View.GONE);
        addButton = findViewById(R.id.add_button);
        backButton = findViewById(R.id.back_button);

        addFlightViewModel = ViewModelProviders.of(this).get(AddFlightViewModel.class);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                errorTextview.setText("");
                if (refrenceNumberTextView.getText() != null && toTextView.getText() != null
                        && refrenceNumberTextView.getText() != null
                        && fromTextView.getText() != null
                        && dateTextView.getText() != null
                        && timeTextView.getText() != null) {
                    String ref = refrenceNumberTextView.getText().toString();
                    String to = toTextView.getText().toString();
                    String from = fromTextView.getText().toString();
                    String date = dateTextView.getText().toString();
                    String time = timeTextView.getText().toString();
                    if (validate(ref, to, from, date, time)) {
                        addFlightViewModel.saveFlight(ref, time, date, to, from);
                        finish();
                        startActivity(new Intent(AddFlightActivity.this, FlightListActivity.class));
                    }
                } else {
                    errorTextview.setText("Please complete all fields");
                    errorTextview.setVisibility(View.VISIBLE);
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddFlightActivity.this, FlightListActivity.class
                ));
            }
        });

    }

    public boolean validate(String ref, String to, String from, String date, String time) {
        if (Validation.validateFlightReferenceNumber(ref) && Validation.validateCity(to)
                && Validation.validateCity(from) && Validation.validateFlightDate(date)
                && Validation.validateFlightTime(time)) {
            errorTextview.setText("");
            errorTextview.setVisibility(View.GONE);
            return true;
        } else {
            if (!Validation.validateFlightReferenceNumber(ref)) {
                errorTextview.setText(errorTextview.getText().toString() + "\n Reference number is incorrect");
            }
            if (!Validation.validateFlightTime(time)) {
                errorTextview.setText(errorTextview.getText().toString() + "\nTime is incorrect");
            }
            if (!Validation.validateFlightTime(date)) {
                errorTextview.setText(errorTextview.getText().toString() + "\nDate is incorrect");
            }
            if (!Validation.validateCity(to)) {
                errorTextview.setText(errorTextview.getText().toString() + "\nDestination is incorrect");
            }
            if (!Validation.validateCity(from)) {
                errorTextview.setText(errorTextview.getText().toString() + "\nOrigin is incorrect");
            }
            errorTextview.setVisibility(View.VISIBLE);
            return false;
        }
    }

}
