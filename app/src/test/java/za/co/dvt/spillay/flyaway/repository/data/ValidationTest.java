package za.co.dvt.spillay.flyaway.repository.data;

import org.junit.Test;

import za.co.dvt.spillay.flyaway.ViewModel.AddFlight.data.Validation;

import static junit.framework.Assert.assertEquals;

/**
 * Created by SPillay on 2018/02/21.
 */


public class ValidationTest {

    @Test
    public void referenceNumberValidationTest() {
        String validReferenceNumber = "AFDRTY";
        String invalidReferenceNumber = "AFDRTY123";

        boolean valid = Validation.validateFlightReferenceNumber(validReferenceNumber);
        boolean invalid = Validation.validateFlightReferenceNumber(invalidReferenceNumber);
        boolean expectedValid = true;
        boolean expectedInvalid = false;

        assertEquals(expectedValid, valid);
        assertEquals(expectedInvalid, invalid);

    }

    @Test
    public void dateValidationTest() {
        String validDate = "02/12/2018";
        String invalidDate = "12/333/2011";

        boolean valid = Validation.validateFlightDate(validDate);
        boolean invalid = Validation.validateFlightDate(invalidDate);


        boolean expectedValid = true;
        boolean expectedInvalid = false;

        assertEquals(expectedValid, valid);
        assertEquals(expectedInvalid, invalid);

    }

    @Test
    public void timeValidationTest() {
        String validTime = "02:03";
        String invalidTime = "100:10";

        boolean valid = Validation.validateFlightTime(validTime);
        boolean invalid = Validation.validateFlightTime(invalidTime);


        boolean expectedValid = true;
        boolean expectedInvalid = false;

        assertEquals(expectedValid, valid);
        assertEquals(expectedInvalid, invalid);
    }

    @Test
    public void cityValidationTest() {
        String validCity = "Johannesburg";
        String invalidCity = "Durb4n";

        boolean valid = Validation.validateCity(validCity);
        boolean invalid = Validation.validateCity(invalidCity);


        boolean expectedValid = true;
        boolean expectedInvalid = false;

        assertEquals(expectedValid, valid);
        assertEquals(expectedInvalid, invalid);
    }
}
