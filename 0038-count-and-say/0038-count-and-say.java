class Solution {
    public String countAndSay(int n) {
        if(n <= 0) return "-1";
        if(n == 1) return "1";
        String result = "1";
        
        for(int i = 1; i < n; ++i){
            result = build(result);
        }
        return result;
    }
    
    public String build(String s){
        int count = 1;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i < s.length(); ++i){
            if(s.charAt(i) == s.charAt(i-1)) ++count;
            else{
                sb.append(count + "" + s.charAt(i-1));
                count = 1;
            }
        }
        sb.append(count + "" + s.charAt(s.length()-1));
        return sb.toString();
    }
}