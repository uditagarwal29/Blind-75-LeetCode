package Strings;

import java.util.*;

public class longestSubStringNoRepeat {
    public static void main(String[] args) {
        String s = "au";
        int i = 0;
        int j = s.length();
        HashMap<Character, Integer> list = new HashMap<Character, Integer>(); // to store character from string and its
                                                                              // index in og string
                                                                              // ensure there are no repeating
                                                                              // characters
        char ch;
        int max_Len = 0;
        while (i < j) {
            ch = s.charAt(i);
            if (list.containsKey(ch)) { // if current character at index i already in longest substring/hashmap
                i = list.get(ch) + 1; // get the index in the string next to where the repeating character occurs
                                      // ex : pwpkew --> current hashmap [(p:0)(w:1)], we are at p at index 3
                                      // we get the index next(w at 2) to the index of last occuring p(p at 0)
                list.clear(); // formation of new substring so that no repeating char occurs
                list.put(s.charAt(i), i); // put the current character (i.e w at index 1) in the hashmap
                i++;

            } else { // if next character not already present in hashmap, add it
                list.put(ch, i);
                i++;
            }
            max_Len = Math.max(max_Len, list.size()); // get max length of hashmap(unique chachters substring)
        }
    
        System.out.println(max_Len);

    }
}
