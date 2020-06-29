package Strings;

/*
Given a non-empty string of lowercase letters and a non-negative integer representing a key, write a function that returns
a new string obtained by shifting every letter in the input string by  k positions in the alphabet, where k is the key.

*/

public class CesarCipherEncryptor {
    public String cesarCipherEncryptor(String str, int key) {
        char[] output = new char[str.length()];
        int newKey = key % 26;
        for (int i = 0; i < str.length(); i++) {
            int newLetter = str.charAt(i) + newKey;
            if (newKey > 122) {
                newKey = 96 + newKey % 122;
            }
            output[i] = (char) newKey;
        }
        return new String(output);
    }
}