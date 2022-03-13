class Solution {
    public String multiply(String num1, String num2) {
        int[] sum = new int[num1.length() + num2.length()];
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i = num1.length()-1; i >= 0; --i){
            for(int j = num2.length()-1; j >= 0; --j){
                int prod = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                prod += sum[i+j+1];
                sum[i+j] += (prod / 10);
                sum[i+j+1] = prod % 10;
                
            }
        }
        
       
        
        for(int num : sum){
            if(sb.length() == 0 && num == 0)
                continue;
            sb.append(String.valueOf(num));
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}