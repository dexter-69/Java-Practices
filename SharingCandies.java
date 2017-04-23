/*
 * Complete the function below.
 */

    static long getCandies(long n, long p) {
        long count = 1;
        long ans = 0;
        Stack<Long> stack = new Stack<Long>();
        boolean flag = false;
        //Trivial case
        if(p == 1) return 1;
        for(long i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                ++count;
                //push the quotient to stack
                if((n / i) != i) {
                    stack.push(n/i);
                }
            }
            //if found , break
            if(count == p) {
                ans = i;
                flag = true;
                break;
            }
        }
		//still not found
        if(!flag) {
            while(count < p) {
				//it means p > count 
                if(stack.isEmpty()) {
                    flag = false;
                    break;
                }
                ans = stack.peek();
                stack.pop();
                ++count;
                flag = true;
            } 
            
        }
		//A number also divides itself so count++
        ++count;
		//If still not found set answer to number itself
        if(!flag) ans = n;
		//if count is greater than p, then ans = 0
        return (p > count ? 0 : ans);
    }

