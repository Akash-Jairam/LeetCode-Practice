class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[] s1Array = new int[26];
        int[] s2Array = new int[26];
	    for(int i = 0; i < s1.length(); i++){
            s1Array[s1.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < s2.length(); i++){
            s2Array[s2.charAt(i) - 'a']++;
            if(i >= n){
                s2Array[s2.charAt(i-n) - 'a']--;
            }
            if(Arrays.equals(s1Array, s2Array))
                return true;
        }
	        return false;
    }
}