class Solution {
    public int consecutiveNumbersSum(int N) {
        int count = 0;
        
        for(int n = 2; n*(n+1)/2 <= N; ++n){
            int val = (N - n * (n+1)/2);
            if( val % n == 0)
                ++count;
        }
        
        return count+1;
    }
    
    // https://www.youtube.com/watch?v=oKOCYZd4m7E
/*
For a given integer N, any set of consecutive integers can only add up once (unique) to value N. Example, for number 5, there is only one (unique) set of two consecutive positive integers that add up to 5, i.e, 2 + 3. There is no other set of two consecutive positive integers that add up to 5 (1+2 or 3+4 not equal to 5, only 2+3 is equal to 5). This is the case for three, four, or any other set of consecutive positive integers.

Now, how to check efficiently if N can be formed from a given set of consecutive positive integers (two, three, four, etc.)? The first integer that can be formed  from sum of n consecutive positive integers is n (n+1) / 2, which is the formula for summation of n numbers. Example, for n = 5, the first integer that can be formed is 15 (1+2+3+4+5). The next integer that can be formed from sum of n consecutive positive integers is 15 + 5  = 20 (2+3+4+5+6). The next after that is 15 + 5 + 5 = 25(3+4+5+6+7), and so on. So to check if N can be formed from five consecutive integers in this example, I just have to check if N - (summation of n consecutive integers) is divisible by n. If it is, I can say that N can be formed from some set of 5 consecutive integers. For example, for N = 20 and n = 3, if 20 - (1+2+3), which is 14 is divisible by 3 (it's not), then this means that I cannot express 20 by any combination of three consecutive positive integers. 
*/
}
