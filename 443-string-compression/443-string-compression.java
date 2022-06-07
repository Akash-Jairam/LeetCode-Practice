class Solution {
    public int compress(char[] chars) {
        if(chars == null || chars.length == 0)
            return 0;
        
        int writeIdx = 0, readIdx = 0;
        
        while(readIdx < chars.length){
            char currChar = chars[readIdx];
            readIdx++;
            int count = 1;
            
            while(readIdx < chars.length && chars[readIdx - 1] == chars[readIdx]){
                ++readIdx;
                ++count;
            }
            
            chars[writeIdx] = currChar;
            ++writeIdx;
            
            if(count > 1){
                String s = "" + count;
                for(int i = 0; i < s.length(); ++i){
                    chars[writeIdx] = s.charAt(i);
                    writeIdx++;
                }
            }
        }
        
        return writeIdx;
    }
}