package com.cua.assignment.util;

public class CipherUtil {

    public static StringBuilder decodeSmallCaseConverter(int val, int k, StringBuilder newString) {
        if (val - k < 97) {
            k -= (val - 97);
            k = k % 26;
            newString.append((char) (123 - k));
        } else {
            newString.append((char) (val - k));
        }
        return newString;
    }


    public static StringBuilder decodeUpperCaseConverter(int val, int k, StringBuilder newString) {
        if (val - k < 65) {
            k -= (val - 65);
            k = k % 26;
            newString.append((char) (91 - k));
        } else {
            newString.append((char) (val - k));
        }
        return newString;
    }

    public static StringBuilder encodeSmallCaseConverter(int val, int k, StringBuilder newString) {
        if (val + k > 122) {
            k -= (122 - val);
            k = k % 26;
            newString.append((char) (96 + k));
        } else {
            newString.append((char) (val + k));
        }
        return newString;
    }

    public static StringBuilder encodeUpperCaseConverter(int val, int k, StringBuilder newString) {
        if (val + k > 90) {
            k -= (90 - val);
            k = k % 26;
            newString.append((char) (64 + k));
        } else {
            newString.append((char) (val + k));
        }
        return newString;
    }
}
