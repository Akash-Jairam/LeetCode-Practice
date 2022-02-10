class Solution {
    public boolean isStrobogrammatic(String num) {
        StringBuilder sb = new StringBuilder(num.length());
        Map<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        map.put('0', '0');
        map.put('1', '1');
        
        for(int i = num.length()-1; i >=0; --i){
            if(map.containsKey(num.charAt(i)))
                sb.append(map.get(num.charAt(i)));
            else
                return false;
        }
       
        return num.equals(sb.toString());
    }
}