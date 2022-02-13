class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        // Create a map to keep track of the insertion points
        // Set every element in the map to -1
        // Iterate through our indices array and check to see if corresponding string in sources is a substring of s
        // If true, we update our map array
        
        // Create a stringbuilder
        // Create a new pointer and set it to 0
        // While that pointer is less than the length of our string
        // If the index in our map that pointer points to is greater than 0
        // We append the string in target that corresponds to that index
        // And we increase our pointer by the size of the original string
        // Append the character at i and we increment i
        // Return our result
        
        int[] map = new int[s.length()];
        Arrays.fill(map, -1);
        for(int i = 0; i < indices.length; ++i ){
            int index = indices[i];
            if(s.substring(index, index + sources[i].length()).equals(sources[i]))
                map[index] = i;
        }
        int j = 0;
        StringBuilder sb = new StringBuilder();
        
        while(j < s.length()){
            if(map[j] >= 0){
                sb.append(targets[map[j]]);
                j += sources[map[j]].length();
            } else{
                sb.append(s.charAt(j));
                ++j;
            }
        }
        
        return sb.toString();
    }
}