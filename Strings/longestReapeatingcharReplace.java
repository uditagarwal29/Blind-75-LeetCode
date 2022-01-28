package Strings;

import java.util.*;

import javax.swing.plaf.synth.SynthSplitPaneUI;

//Explanation provided in Image longestReapeatingcharReplace_Explanation.png or OneNote LeetCode notebook
public class longestReapeatingcharReplace {
    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        int sIdx = 0;
        int[] count = new int[26];
        int currCount = 0, maxCount = 0, maxLen = 0;
        for (int eIdx = 0; eIdx < s.length(); eIdx++) {
            currCount = ++count[s.charAt(eIdx) - 'A'];
            maxCount = Math.max(maxCount, currCount);
            if ((eIdx - sIdx + 1) - maxCount > k) {
                count[s.charAt(sIdx) - 'A']--;
                sIdx++;
            }
            maxLen = Math.max(maxLen, (eIdx - sIdx + 1));
        }
        System.out.print(maxLen);
    }
}
