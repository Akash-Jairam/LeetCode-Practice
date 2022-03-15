class Solution {
    public String addBinary(String a, String b) {
        // Create 4 vars, two to track the current index of a and b( starting from the last index)
        // one to track the carry and another to track the current sum 
        // Use a while loop that will only finish when both indexes are less than zero
        // If the current index of a or b is greater than 0, add the character at that index to the sum and decrement the current index
        // Add the carry to the sum
        // Add sum / 2 to the current string
        // Add sum % 2 to carry
        // Set sum to zero again
        int bIndex = b.length()-1, aIndex = a.length()-1;
        int sum = 0, carry = 0;
        String res = "";
        
        while(aIndex >= 0 || bIndex >= 0){
            if(aIndex >= 0){
                sum += a.charAt(aIndex) - '0';
                --aIndex;
            }
            
            if(bIndex >= 0){
                sum += b.charAt(bIndex) - '0';
                --bIndex;
            }
            
            sum += carry;
            res = String.valueOf(sum % 2) + "" +  res;
            carry = sum  < 2 ? 0 : 1;
            sum = 0;
        }
        
        if(carry > 0)
            res = String.valueOf(carry) + "" + res;
        
        return res;
    }
}