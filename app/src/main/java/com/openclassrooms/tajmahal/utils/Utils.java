package com.openclassrooms.tajmahal.utils;

import java.text.DecimalFormat;

public abstract class Utils {
    public Utils() {}

    public static String convertFloatTo1DecimalString(float floatValue) {
//        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        return decimalFormat.format(floatValue);
    }
}
