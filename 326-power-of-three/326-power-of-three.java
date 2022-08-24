class Solution {
    public boolean isPowerOfThree(int n) {
        // 3^x = n
        // xlog3 = logn
        // x = logn /log3
        int power = (int) Math.round(Math.log(n) / Math.log(3));
        return Math.pow(3, power) == n;
    }
}