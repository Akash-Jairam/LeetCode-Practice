class Solution {
    public String multiply(String num1, String num2) {
        // Create an array which size is the combined length of the two strings
        // Create a stringBuilder to hold the result
        // Use a nested loop to iterate through both strings from right to left
        // Assign the value at the sum of the indices to the quotient of the product divided by 10
        // Add the remainder of the product divided by 10 to the sum of the indices plus 1
        // Iterate through the array and add each element to the stringbuilder
        // If the length of the string builder is 0, return 0, else return the string value of the string builder
        int m = num1.length();
        int n = num2.length();
        int[] prod = new int[m + n];
        StringBuilder sb = new StringBuilder(m+n);
        
        for(int i = m - 1; i >= 0; --i){
            for(int j = n - 1; j >= 0; --j){
                int curr = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                curr += prod[i+j+1];
                prod[i+j]+= curr / 10;
                prod[i+j+1] = curr % 10;
            }
        }
        
        for(int num : prod){
            if(!(sb.length() == 0 && num == 0))
                sb.append(num);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}