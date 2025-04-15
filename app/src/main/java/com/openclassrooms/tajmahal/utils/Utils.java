package com.openclassrooms.tajmahal.utils;

import java.text.DecimalFormat;

public abstract class Utils {
    public Utils() {}

    /**
     * Converts a float value to a string representation with one decimal place.
     *
     * <p>This method uses {@link DecimalFormat} to format the float value
     * to a string with exactly one digit after the decimal point (e.g., {@code 4.0}, {@code 3.7}).</p>
     *
     * @param floatValue the float value to be formatted
     * @return a string representation of the float with one decimal place
     */
    public static String convertFloatTo1DecimalString(float floatValue) {
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        return decimalFormat.format(floatValue);
    }
}
