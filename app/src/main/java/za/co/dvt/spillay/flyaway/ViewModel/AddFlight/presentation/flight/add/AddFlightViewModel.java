package za.co.dvt.spillay.flyaway.ViewModel.AddFlight.presentation.flight.add;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.Injection;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data.Flight;
import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.repository.FlightRepository;


public class AddFlightViewModel extends AndroidViewModel {

    private FlightRepository flightRepository;

    public AddFlightViewModel(@NonNull Application application) {
        super(application);
        flightRepository = Injection.getFlightRepositoryInstance(application);
    }

    public void saveFlight(String referenceNumber, String time, String date, String to, String from) {
        Flight flight = new Flight(referenceNumber, date, time, from, to);

        flightRepository.insertFlight(flight).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
