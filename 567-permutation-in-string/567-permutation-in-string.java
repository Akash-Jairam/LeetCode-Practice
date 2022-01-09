class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Array = new int[26];
        int[] s2Array = new int[26];
        int k = s1.length();
        
        for(int i = 0; i < s1.length(); i++){
            s1Array[s1.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < s2.length(); i++){
            s2Array[s2.charAt(i) - 'a']++;
            if(i >= s1.length())
                s2Array[s2.charAt((i -k)) - 'a']--;
            if(Arrays.equals(s1Array, s2Array))
                return true;
        }
        
        return false;
    }
}