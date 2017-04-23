import java.util.*;

public class Solution {
    static boolean check(int []a, int n) {
        Stack<Integer> stack = new Stack<Integer>();
        int root = -1;
        for(int i = 0;i < n; i++) {
            if(a[i] < root)
                return false;

            while(!stack.isEmpty() && a[i] > stack.peek()) {
                root = stack.peek();
                stack.pop();
            }
            stack.push(a[i]);
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while(q --> 0) {
            int n = scan.nextInt();
            int []a = new int[n];
            for(int i = 0; i < n; i++) a[i] = scan.nextInt();
            System.out.println(check(a, n) == true ? "YES" : "NO");
        }
    }
}