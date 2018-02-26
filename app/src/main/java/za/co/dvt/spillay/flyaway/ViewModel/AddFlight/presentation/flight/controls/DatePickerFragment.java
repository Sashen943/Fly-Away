package za.co.dvt.spillay.flyaway.ViewModel.AddFlight.presentation.flight.controls;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

import java.util.Calendar;
import java.util.Date;

/**
 * @author SPillay
 */

public class DatePickerFragment extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendarInstance = Calendar.getInstance();
        int year = calendarInstance.get(Calendar.YEAR);
        int month = calendarInstance.get(Calendar.MONTH);
        int day = calendarInstance.get(Calendar.DAY_OF_MONTH);

        if (getActivity() != null) {
            DatePickerDialog dialog = new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), year, month, day);
            dialog.getDatePicker().setMinDate(new Date().getTime());
            return dialog;
        } else {
            return super.onCreateDialog(savedInstanceState);
        }
    }
}
