package za.co.dvt.spillay.flyaway.ViewModel.AddFlight.presentation.flight.add;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import za.co.dvt.spillay.flyaway.R;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data.Validation;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.presentation.flight.controls.DatePickerFragment;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.presentation.flight.controls.TimePickerFragment;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.presentation.flight.list.FlightListActivity;

public class AddFlightActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    TextView toTextView, fromTextView, dateTextView, timeTextView, refrenceNumberTextView, errorTextview;
    Button addButton, backButton, dateButton, timeButton;
    AddFlightViewModel addFlightViewModel;
    String date;
    String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_flight);

        refrenceNumberTextView = findViewById(R.id.txt_flight_reference_number);
        dateTextView = findViewById(R.id.textview_date);
        timeTextView = findViewById(R.id.textview_time);
        toTextView = findViewById(R.id.txt_flight_to);
        fromTextView = findViewById(R.id.txt_flight_from);
        dateButton = findViewById(R.id.button_date);
        timeButton = findViewById(R.id.button_time);
        errorTextview = findViewById(R.id.errorTextView);
        errorTextview.setVisibility(View.GONE);
        addButton = findViewById(R.id.add_button);
        backButton = findViewById(R.id.back_button);
        setOnClickListeners();
        addFlightViewModel = ViewModelProviders.of(this).get(AddFlightViewModel.class);


    }

    public boolean validate(String ref, String to, String from, String date, String time) {
        if (Validation.validateFlightReferenceNumber(ref) && Validation.validateCity(to)
                && Validation.validateCity(from)) {
            errorTextview.setText("");
            errorTextview.setVisibility(View.GONE);
            return true;
        } else {
            if (!Validation.validateFlightReferenceNumber(ref)) {
                errorTextview.setText(errorTextview.getText().toString() + "\n Reference number is incorrect");
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


    public void setOnClickListeners() {

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
                    if (validate(ref, to, from, date, time)) {
                        addFlightViewModel.saveFlight("#" + ref, time, date, to, from);
                        startActivity(new Intent(AddFlightActivity.this, FlightListActivity.class));
                        finish();
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

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerFragment datePicker = new DatePickerFragment();
                datePicker.show(getFragmentManager(), "date frag");
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerFragment timePickerFragment = new TimePickerFragment();
                timePickerFragment.show(getSupportFragmentManager(), "time frag");
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        date = Integer.toString(dayOfMonth) + "/" + Integer.toString(month) + "/" + Integer.toString(year);
        dateTextView.setText(date);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        time = Integer.toString(hourOfDay) + ":" + Integer.toString(minute);
        timeTextView.setText(time);
    }
}
