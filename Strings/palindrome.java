package Strings;

public class palindrome {
    public static void main(String[] args) {
        String s = "ab   -  !@#$%^&*()_+-={}[]|;<,>.?/~`      a";
        s = s.toLowerCase(); // string to all lowercase
        s = s.replaceAll("[^a-z0-9]", ""); // remove all character excluding a-z and 0-9 --->alphanumerical string allowed

        StringBuffer temp = new StringBuffer(s); // To reverse the string // convert to String Buffer
        temp.reverse();
        String revS = temp.toString(); // converting reversed StringBuffer object to String object so that .equals can be used.

        System.out.println(s);
        System.out.println(revS);
        System.out.println(s.equals(revS));

    }
}
