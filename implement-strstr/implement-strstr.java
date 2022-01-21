class Solution {
    public int strStr(String haystack, String needle) {
        if((haystack.isEmpty() && needle.isEmpty()) || needle.isEmpty())
            return 0;
        if(haystack.isEmpty())
            return -1;
        int[] haystackArray = new int[26];
        int[] needleArray = new int[26];
        int needleSize = needle.length();
        
        for(int i = 0; i < needle.length(); ++i){
            needleArray[needle.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < haystack.length(); ++i){
            haystackArray[haystack.charAt(i) - 'a']++;
            if(i >= needleSize)
                haystackArray[haystack.charAt(i-needleSize) - 'a']--;
            if(Arrays.equals(haystackArray, needleArray) && haystack.substring(i - needleSize + 1, i+1).equals(needle))
                return i-needleSize+1;
        }
        
        return -1;
    }
}