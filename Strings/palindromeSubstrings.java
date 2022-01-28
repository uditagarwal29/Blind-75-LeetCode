package Strings;
//LOGIC : minor modifications done in longest palindromic substring problem.

public class palindromeSubstrings {
    public static int expand(String s, int left, int right) {
        if (s == null || left > right) {
            return 0;
        }
        int temp_count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            temp_count++;
        }
        return temp_count;
    }

    public static void main(String[] args) {
        String s = "abc";
        int len = s.length();
        int count = 0;
        if (s == null || len < 1) {
            count = 0;
        } else if (len == 1) {
            count = 1;
        } else {
            int sIdx = 0;
            int eIdx = 0;
            for (int i = 0; i < s.length(); i++) {
                int count1 = expand(s, i, i + 1); // counts all the single char substrings and all the odd length substrings
                int count2 = expand(s, i, i);// counts all the even length substrings
                count = count + count1 + count2; 
            }
        }

        System.out.println(count);

    }
}
