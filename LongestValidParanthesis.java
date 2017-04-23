import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static int getLongestParanthesis(String in) {
        
        //trivial case
        if(in.length() == 0 || in.length() == 1) return 0;
        
        //save max length and lastIdx stores last index after which we got an opening bracket
        int maxLen = 0, lastIdx = -1;
        //store the indexes of opening brackets
        Stack<Integer> saveIndex = new Stack<Integer>();
        for(int i = 0; i < in.length(); i++) {
            if(in.charAt(i) == '(') saveIndex.push(i);
            else {
                if(saveIndex.isEmpty()) lastIdx = i;
                else {
                    saveIndex.pop();
                    if(saveIndex.isEmpty()) maxLen = Math.max(maxLen, i - lastIdx);
                    else maxLen = Math.max(maxLen, i - saveIndex.peek());
                }
            }
        }
        return maxLen;
    }
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while(q --> 0) {
            String paranthesis = scan.next();
            System.out.println(getLongestParanthesis(paranthesis));
        }
    }
}