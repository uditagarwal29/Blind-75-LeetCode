package Strings;

import java.util.ArrayList;

public class longestPalindromicSubstring {
    public static int expand(String s, int left, int right) {
        if (s == null || left > right) {
            return 0;
        }
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) { // we are moving left to more
                                                                                       // left and right to more right
                                                                                       // as long as we are getting same
                                                                                       // characters at left and right
                                                                                       // index
            left--;
            right++;
        }
        return right - left - 1; // we do +1 because when the last time loop runs,e.g in "racecar" when left is
                                 // at 0 and right is at 6, s[0]==s[6], so we do left-- and right--
                                 // and becomes left = -1 right= 4 which is one more than what we actually need
                                 // to undo the effect of last run of loop by increasing left by 1
                                 // and decreasing right by 1
                                 // ( R -1 ) - ( L +1 ) + 1 (+1 at end is because actual length is +1 than index
                                 // length)
                                 // R -1 - L -1 + 1
                                 // R -L -2 + 1
                                 // R - L -1
    }

    public static void main(String[] args) {
        String s = "abba";
        int len = s.length();
        String ans = "";
        if (s == null || len < 1) {
            ans = "";
        } else if (len == 1) {
            ans = s;
        } else {
            int sIdx = 0;
            int eIdx = 0;
            for (int i = 0; i < s.length(); i++) {
                int len1 = expand(s, i, i + 1); // for even length palindromes -> e,g abbbbx -> we take left and right
                                                // one index apart and expand
                int len2 = expand(s, i, i); // for odd length palindromes -> we take a center and expand left and right
                int currMax = Math.max(len1, len2);
                if (currMax > eIdx - sIdx) {
                    sIdx = i - ((currMax - 1) / 2);
                    eIdx = i + (currMax / 2);
                }
            }
            ans = s.substring(sIdx, eIdx + 1);
        }

        System.out.println(ans);

    }
}

// METHOD 2
// WRONG BECAUSE WONT WORK FOR EVEN LENGTH PALINDROMES :( ---> Correction IN
// ABOVE METHOD
// public class longestPalindromicSubstring {

// public static void main(String[] args) {
// String s = "aabaaxydyxaa";
// int leftP = 0;
// int c = 1;
// int rightP = 2;
// int len = s.length();
// ArrayList<Character> ans = new ArrayList<Character>();
// String halfresult = "";
// String result = "";
// if (s.length() == 0) {
// ans.add(null);

// } else if (s.length() == 1) {
// ans.add(s.charAt(0));
// } else if (s.length() == 2) {
// if (s.charAt(0) == s.charAt(1)) {
// ans.add(s.charAt(0));
// ans.add(s.charAt(1));
// } else {
// ans.add(s.charAt(0));
// }
// } else {

// while (c < s.length() - 1) {

// if ((leftP < 0 || rightP >= s.length()) || s.charAt(leftP) !=
// s.charAt(rightP)) {

// if (halfresult.length() < ans.size()) {
// halfresult = "";
// for (char ch : ans) {
// halfresult += ch;
// }
// StringBuffer temp = new StringBuffer(halfresult); // To reverse the string //
// // convert to String
// // Buffer
// temp.reverse();
// temp.deleteCharAt(temp.length() - 1);
// result = temp + halfresult;
// }

// ans.clear();
// c++;
// ans.add(s.charAt(c));
// leftP = c - 1;
// rightP = c + 1;
// }

// else if (s.charAt(leftP) == s.charAt(rightP)) {
// // if (leftP == c - 1) {
// // ans.add(s.charAt(c));
// // }
// ans.add(s.charAt(leftP));
// leftP--;
// rightP++;
// }
// }
// System.out.println(result);

// }

// }
// }
