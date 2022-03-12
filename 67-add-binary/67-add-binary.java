class Solution {
    public String addBinary(String a, String b) {
        String res = "";
        int aIndex = a.length()-1;
        int bIndex = b.length()-1;
        int carry = 0;
        int sum = 0;
        
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
            res = ((sum) % 2) + "" + res;
            carry = sum / 2;
            sum = 0;
        }
        
        if(carry > 0){
            res = "1" + "" + res;
        }
        
        return res;
    }
}