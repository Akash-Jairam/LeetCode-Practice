class Solution {
    public String intToRoman(int num) {
        String romanVal = "";
        int[] value = new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] letters = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        for(int i = letters.length-1; i >=0; --i){
            if(num / value[i] > 0){
                for(int j = 0; j < num / value[i]; ++j){
                    romanVal += letters[i];
                }
                num %= value[i];
            }
        }
            
      return romanVal;   
    }
    
    
}