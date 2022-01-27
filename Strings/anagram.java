package Strings;

import java.util.*;

//Anagram is possible if 2 conditions are met :
//1) Length of both strings is same
//2) Both same contain same characters , with each character having same freq
//Solution is converting String to character array, sorting the character array, converting it back to string and comparing the sorted strings

public class anagram {
    public static String sort(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return String.copyValueOf(ch);
    }

    public static void main(String[] args) {
        String s = "";
        String t = "";
        if (s.length() != t.length()) {
            System.out.println("false");
        } else {
            if (sort(s).equals(sort(t))) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }

    }
}
