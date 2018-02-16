package za.co.dvt.spillay.flyaway.ViewModel.AddFlight.presentation.flight.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import za.co.dvt.spillay.flyaway.R;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.presentation.flight.list.FlightListActivity;


/**
 * Created by SPillay on 2018/02/13.
 */

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                changeScreen();
                finish();
            }
        }, 3000);
    }

    public void changeScreen() {
        startActivity(new Intent(SplashScreenActivity.this, FlightListActivity.class));
    }
}

