package org.papaja.adminfly.commons.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class Randomizer {

    public static String getRandomAlpha(int length) {
        return RandomStringUtils.random(length, true, true);
    }

    public static String getRandomString(int length) {
        return RandomStringUtils.random(length, true, false);
    }

    public static String getRandomNumber(int length) {
        return RandomStringUtils.random(length, false, true);
    }

    public static String getRandomHexadecimal(int length) {
        return RandomStringUtils.random(length, "0123456789abcdef".toCharArray());
    }

}
