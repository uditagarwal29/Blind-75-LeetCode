package Strings;

import java.util.*;

//USING STACK 

public class paranthesis {
    public static void main(String[] args) {
        String s = "{}{}[()]{";
        HashMap<Character, Character> db = new HashMap<Character, Character>();
        db.put('(', ')');
        db.put('[', ']');
        db.put('{', '}');
        Stack<Character> bktStack = new Stack<Character>();
        int i = 0;
        char recentBkt;
        while (i < s.length()) {
            recentBkt = s.charAt(i);
            if (db.containsKey(recentBkt)) { // add to stack if recentBkt is a open bkt 
                bktStack.push(recentBkt);   
                i++; // check next bracket
                continue;
            }

            // To be able to make a complete bracket pair, the current bracket must be
            // closing the top most element in Stack.

            //CONDITIONS FOR DETECTNG A BRACKET PAIR AND REMOVING IT FROM STACK
            //1ST : bracketStack should not be empty if we want to pop the top opening bracket
            //2ND : The top most element in bracket Stack must be an opening bracket
            //3rd : If 2nd is true , then the current bkt must be the corresponding closing bracket of the top most opening bracket

            if (bktStack.empty() == false && db.containsKey(bktStack.peek()) && recentBkt == db.get(bktStack.peek())) {
                bktStack.pop();  //completes a true bracket pair --> {} , () or []
                i++;
            } else {
                bktStack.push(recentBkt);  // adds the closing bracket to stack, if its pair is not completed
                i++;
            }
        }

        System.out.println(bktStack.empty());

    }
}
