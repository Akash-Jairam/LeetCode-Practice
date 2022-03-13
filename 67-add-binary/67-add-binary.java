class Solution {
    public String addBinary(String a, String b) {
        int aIndex = a.length()-1;
        int bIndex = b.length()-1;
        String sum = "";
        int curr = 0;
        int carry = 0;
        // Create vars to track the indices of a and b as well as the sum and carry
        // Do a while loop that does not end until both indexes are below zero
        // If either index is > 0, add that number to the sum
        // Add sum to carry
        // Add mod to current string
        // Set carry to dividend
        // If carry is greater than zero, prepend carry to string
        while(aIndex >= 0 || bIndex >= 0){
            if(aIndex >= 0){
                curr += (a.charAt(aIndex) - '0');
                --aIndex;
            }
            
            if(bIndex >= 0){
                curr += (b.charAt(bIndex) - '0');
                --bIndex;
            }
            
            curr += carry;
            sum = (curr % 2) + "" + sum;
            carry = curr / 2;
            curr = 0;
        }
        
        if(carry > 0){
            sum = carry + "" + sum;
        }
        
        return sum;
    }
}