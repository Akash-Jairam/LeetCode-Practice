class Solution {
    public String decodeString(String s) {
        Stack<Integer> repeat = new Stack();
        Stack<String> pieces = new Stack();
        int index = 0;
        String res = "";
        while(index < s.length()){
            char curr = s.charAt(index);
            if(Character.isDigit(curr)){
                int number = 0;
                while(Character.isDigit(s.charAt(index))){
                    number = number * 10 + (s.charAt(index) - '0');
                    ++index;
                }
                repeat.push(number);
            } else if(curr == '['){
                pieces.push(res);
                res = "";
                ++index;
            } else if(curr == ']'){
                int count = repeat.pop();
                StringBuilder temp = new StringBuilder(pieces.pop());
                for(int i = 0; i < count; ++i){
                    temp.append(res);
                }
                res = temp.toString();
                ++index;
            } else{
                res += curr;
                ++index;
            }
            
        }
        
        return res;
    }
}