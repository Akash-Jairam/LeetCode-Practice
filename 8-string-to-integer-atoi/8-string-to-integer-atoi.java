class Solution {
    public int myAtoi(String s) {
        if(s == null || s.isEmpty() || s.isBlank())
            return 0;
        
        int i = 0, sign = 1, res = 0, max = Integer.MAX_VALUE, min = Integer.MIN_VALUE;
        
        while(s.charAt(i) == ' ')
            ++i;
        
        if(s.charAt(i) == '-' || s.charAt(i) == '+'){
            sign = s.charAt(i) == '-' ? -1 : 1;
            ++i;
        }
        
        while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            if(res > max / 10 ||(res == max / 10 && s.charAt(i) > '7'))
                return sign == 1 ? max : min;
                
            res = res * 10 + (s.charAt(i) - '0');
            ++i;
        }
                
        return res * sign;
    }
}