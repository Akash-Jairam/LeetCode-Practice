class Solution {
    public String decodeString(String s) {
        if(s == null || s.isEmpty())
            return s;
        
        Stack<Integer> nums = new Stack<>();
        Stack<String> pieces = new Stack<>();
        String curr = "";
        
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                int num = 0;
                while(Character.isDigit(s.charAt(i))){
                    num = num * 10 + (s.charAt(i) - '0');
                    ++i;
                }
                nums.push(num);
                --i;
            } else if(c == '['){
                pieces.push(curr);
                curr = "";
            } else if(c == ']'){
                int count = nums.pop();
                StringBuilder temp = new StringBuilder(pieces.pop());
                for(int j = 0; j < count; ++j){
                    temp.append(curr);
                }
                curr = temp.toString();
            } else {
                curr += c;
            }
        }
        
        return curr;
    }
}