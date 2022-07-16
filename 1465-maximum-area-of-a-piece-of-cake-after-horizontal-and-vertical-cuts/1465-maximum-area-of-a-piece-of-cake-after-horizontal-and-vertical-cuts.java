class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        int maxVert = 0, maxHori = 0;
        int prev = 0;
        for(int i = 0; i < verticalCuts.length; ++i){
            maxVert = Math.max(maxVert, verticalCuts[i] - prev);
            prev = verticalCuts[i];
        }
        
        maxVert = Math.max(maxVert, w - prev);
        prev = 0;
        for(int i = 0; i < horizontalCuts.length; ++i){
            maxHori = Math.max(maxHori, horizontalCuts[i] - prev);
            prev = horizontalCuts[i];
        }
        
        maxHori = Math.max(maxHori, h - prev );
        
        return (int)((long) maxVert * maxHori % 1000000007) ;
    }
}