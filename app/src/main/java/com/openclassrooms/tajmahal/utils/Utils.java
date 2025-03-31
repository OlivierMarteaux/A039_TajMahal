package com.openclassrooms.tajmahal.utils;

import java.text.DecimalFormat;

public abstract class Utils {
    public Utils() {}

    public static String convertFloatTo1DecimalString(float floatValue) {
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        return decimalFormat.format(floatValue);
    }
}
