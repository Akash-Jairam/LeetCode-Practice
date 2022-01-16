class Solution {
    public int heightChecker(int[] heights) {
        int[] copy = Arrays.copyOf(heights, heights.length);
        Arrays.sort(copy);
        int numWrong = 0;
        
        for(int i = 0; i < heights.length; i++){
            if(copy[i] != heights[i])
                numWrong++;
        }
        
        return numWrong;
    }
}