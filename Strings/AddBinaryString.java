package Strings;

public class AddBinaryString {
    public String addBinaryStrings(String s1, String s2) {
        int total = binaryToBase10(s1) + binaryToBase10(s2);
        return base10ToBinary(total);
    }

    private int binaryToBase10(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                result += Math.pow(2, (s.length() - 1 - i));
            }
        }
        return result;
    }

    private String base10ToBinary(int number) {
        if (number == 0)
            return "0";
        StringBuilder result = new StringBuilder();
        while (number != 0) {
            if (number % 2 == 0) {
                result.append("0");
            } else {
                result.append("1");
            }
            number /= 2;
        }
        return result.reverse().toString();
    }
}