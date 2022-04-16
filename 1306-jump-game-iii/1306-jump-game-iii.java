class Solution {
    public boolean canReach(int[] arr, int start) {
        return traverse(arr, start, new boolean[arr.length]);
    }
    
    public boolean traverse(int[] arr, int start, boolean[] visited){
        if(start >= arr.length || start < 0 || visited[start])
            return false;
        
        if(arr[start] == 0)
            return true;
        
        
        
        visited[start] = true;
        
        return traverse(arr, start + arr[start], visited) || traverse(arr, start - arr[start], visited);
        
    }
}