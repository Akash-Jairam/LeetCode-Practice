class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        CharacterComparator cc = new CharacterComparator();
        Arrays.sort(properties, cc);
        int count = 0;
        
        int max = Integer.MIN_VALUE;
        for(int i = properties.length - 1; i >= 0; --i){
            if(properties[i][1] < max)
                ++count;
            
            max = Math.max(max, properties[i][1]);
        }
        
        return count;
    }
    
    class CharacterComparator implements Comparator<int[]>{
        @Override
        public int compare(int[] a, int[] b){
            if(a[0] == b[0])
                return b[1] - a[1];
            
            return a[0] - b[0];
        }
    }
}