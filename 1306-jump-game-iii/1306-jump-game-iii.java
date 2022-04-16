class Solution {
    public boolean canReach(int[] arr, int start) {
        return traverse(arr, start, new boolean[arr.length]);
    }
    
    public boolean traverse(int[] arr, int start, boolean[] visited){
        if(arr[start] == 0)
            return true;
        
        if(visited[start])
            return false;
        
        visited[start] = true;
        
        int forwardJump = start + arr[start];
        int backwardJump = start - arr[start];
        boolean canForward = false;
        boolean canBackward = false;
        
        if(forwardJump >= 0 && forwardJump < arr.length)
            canForward = traverse(arr, forwardJump, visited);
        
        if(backwardJump >= 0 && backwardJump < arr.length)
            canBackward = traverse(arr, backwardJump, visited);
        
        return canForward || canBackward;
    }
}