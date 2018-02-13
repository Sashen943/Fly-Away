package za.co.dvt.spillay.flyaway.ViewModel.AddFlight.presentation.flight.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import za.co.dvt.spillay.flyaway.R;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.presentation.flight.list.FlightListActivity;

/**
 * Created by SPillay on 2018/02/13.
 */

public class SplashScreenActivity extends AppCompatActivity {

    private static int TIME_OUT = 4000;
    ImageView planeImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        planeImageView = findViewById(R.id.plane_image_view);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setContentView(R.layout.activity_slpash_screen_2);
                changeScreen();
                finish();
            }
        }, 1000);

    }

    public void changeScreen() {
        startActivity(new Intent(SplashScreenActivity.this, FlightListActivity.class));
    }
}

