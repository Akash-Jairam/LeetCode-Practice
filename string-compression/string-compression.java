class Solution {
    public int compress(char[] chars) {
        char pre = ' ';
        int num = 0, last = 0, i = 0;
        
        while(i <= chars.length){
            char curr = i == chars.length ? ' ' : chars[i];
            ++i;
            if((pre!=' ' && curr!=pre)||curr==' '){
                chars[last] = pre;
                if(num != 1){
                    String number = num+"";
                    int len = number.length();
                    for(int j=0;j<len;j++){
                        chars[++last] = number.charAt(j);
                    }
                }
                last ++;
                num = 1;
            } else {
                ++num;
            }
            pre = curr;
            
        }
        
        return last;
    }
}