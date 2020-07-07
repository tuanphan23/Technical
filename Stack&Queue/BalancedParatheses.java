package Stack&Queue;

import java.util.*;

/*
You are given a string with 3 types of tokens, each with an "open" type and "closed" type.

A string is "balanced" if all open tokes of a certain type are closed appropriately.

Given a string s, return true if it is balanced, return false otherwise.

Opening tokens:
An open parenthesis (
An open bracket [
An open brace {

Closing tokens:
A closing parenthesis )
A closing bracket ]
A closing brace }
*/

public class BalancedParatheses {
    public boolean isValid(String s) {
        Map<Character, Character> MapCloseToOpen = new HashMap<Character, Character>();
        Stack<Character> stack = new Stack<Character>();

        MapCloseToOpen.put(')', '(');
        MapCloseToOpen.put('}', '{');
        MapCloseToOpen.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (MapCloseToOpen.containsKey(c)) {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (stack.pop() != MapCloseToOpen.get(c)) {
                        return false;
                    }
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}