/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 *     public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */

class Solution {
    int count = 0;
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        return helper(sea, topRight, bottomLeft);
        
    }
    
    public int helper(Sea sea, int[] topRight, int[] bottomLeft) {
        if(!sea.hasShips(topRight, bottomLeft))
            return 0;
        
        if(topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1]){
            return 1;
        }
        
        int midX = (topRight[0] + bottomLeft[0]) / 2;
        int midY = (topRight[1] + bottomLeft[1]) / 2;

        return helper(sea, new int[]{midX, midY}, bottomLeft) +
               helper(sea, topRight, new int[]{midX+1, midY+1}) +
               helper(sea, new int[]{topRight[0], midY}, new int[]{midX+1, bottomLeft[1]}) +
               helper(sea, new int[]{midX, topRight[1]}, new int[]{bottomLeft[0], midY+1});
        
    }
}

//0,2
//2,4

// 0, 0 && 4,4