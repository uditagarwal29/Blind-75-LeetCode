package Strings;

import java.util.*;

//see anagrams.java before this
//aet : [eat, tea, ate]abt : [bat] ant : [tan, nat]
public class groupAnagram {
    public static String sort(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return String.copyValueOf(ch);
    }
    public static void main(String[] args) {
        String strs[] = { "eat", "tea", "tan", "ate", "nat", "bat" };

        List<List<String>> ans = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>(); // Hashmap to store all the
                                                                                          // possible anagrams,and
        // Array list as value pair to store the strings that can make those anagrams

        for (int i = 0; i < strs.length; i++) {
            String sorted_S = sort(strs[i]); // we sort the current string from array and stored the sorted version of it.
                                             // because all the other strings that might be its anagram will also have the same sorted form.
                                             // example : the sorted forms in the input strings are { aet, abt, ant}
                                             // and the strings that can make this sorted form are :
                                             // aet : [eat, tea, ate]abt : [bat] ant : [tan, nat]

            if (hm.containsKey(sorted_S)) { // if hashmap already contains this sorted form , we check is the current string'sorted form(which
                                            //is same as any other string's sorted form which might be its anagram).
                                            //if found we add the current string to the arrayList value of that key in hashmap
                hm.computeIfAbsent(sorted_S, k -> new ArrayList<>()).add(strs[i]);
            } else {
                hm.computeIfAbsent(sorted_S, k -> new ArrayList<>()).add(strs[i]); //if that sorted form hasnt been added yet, we 
                                                                                // add it as key and its arrayList value is initialized with
                                                                                // current string

            }
        }

        for (String key : hm.keySet()) {
            ans.add(hm.get(key));  //Filling up answer List with hashmap values.
        }

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
