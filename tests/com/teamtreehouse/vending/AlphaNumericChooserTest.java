package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by Randika Lakmal on 1/7/2018.
 */
public class AlphaNumericChooserTest {

    private AlphaNumericChooser chooser;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        chooser = new AlphaNumericChooser(26,10);
    }

    @Test
    public void validInputReturnsProperLocation() throws Exception {

        AlphaNumericChooser.Location location= chooser.locationFromInput("B4");

        assertEquals("Proper Row :",1,location.getRow());
        assertEquals("Proper Column :",3,location.getColumn());

    }

    @Test(expected = InvalidLocationException.class)
    public void choosingWrongInputIsNotAllowed() throws Exception {
        chooser.locationFromInput("WRONG");
    }

    @Test(expected = InvalidLocationException.class)
    public void choosingLagerThanMaxIsNotAllowed() throws Exception {
        chooser.locationFromInput("B412");

    }

    @Test
    public void constructingLagerThanAlphabetNotAllowed() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Maximum rows supported is 26");
        new AlphaNumericChooser(27,10);
    }
}