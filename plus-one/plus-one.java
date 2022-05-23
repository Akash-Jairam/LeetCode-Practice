class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        digits[digits.length - 1]++;
        for(int i = digits.length - 1; i >= 0; --i){
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        
        if(carry > 0){
            int[] res = new int[digits.length+1];
            for(int i = digits.length - 1; i >= 0; --i){
                res[i+1] = digits[i];
            }
            res[0] = carry;
            return res;
        }
        
        return digits;
    }
}