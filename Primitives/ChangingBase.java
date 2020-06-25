package Primitives;

/*
Given an integer (represented as a string) under base b1, convert it to base b2.
idea: convert to base 10 first then from base 10 convert to the final base
*/

public class ChangingBase {
    public String changeBase(String numAsString, int b1, int b2) {
        boolean isNegative = numAsString.startsWith("-");
        int startIndex = isNegative ? 1 : 0;
        int length = numAsString.length();
        int maxPower = length - 1;
        int numberUnderBase10 = 0;

        for (int i = startIndex; i < length; i++) {
            boolean isDigit = Character.isDigit(numAsString.charAt(i));
            int value = isDigit ? numAsString.charAt(i) - '0' : numAsString.charAt(i) - 'A';
            numberUnderBase10 += (int) value * Math.pow(b1, maxPower - i);
        }

        if (numberUnderBase10 == 0) {
            return "0";
        } else {
            return (isNegative ? "-" : "") + base10ToNewBase(numberUnderBase10, b2);
        }
    }

    // helper function to convert from base 10 to new base
    private String base10ToNewBase(int base10AsString, int newBase) {
        if (base10AsString == 0) {
            return "";
        }
        char lastDigit;
        int newBaseDigit = base10AsString % newBase;
        boolean isHex = newBaseDigit >= 10;
        if (isHex) {
            lastDigit = (char) (newBaseDigit + 'A' - 10);
        } else {
            lastDigit = (char) (newBaseDigit + '0');
        }

        int remain = base10AsString / newBase;
        String NewBaseAsString = base10ToNewBase(remain, newBase);

        return NewBaseAsString + lastDigit;

    }
}
