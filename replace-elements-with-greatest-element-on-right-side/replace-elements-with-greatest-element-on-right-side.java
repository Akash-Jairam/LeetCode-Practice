class Solution {
    public int[] replaceElements(int[] arr) {
        /* Iterate from the back to the start,
We initilize mx = -1, where mx represent the max on the right.
Each round, we set A[i] = mx, where mx is its mas on the right.
Also we update mx = max(mx, A[i]), where A[i] is its original value. */
        int mx = -1;
        
        for(int i = arr.length-1; i >= 0; i--){
            int temp = arr[i];
            arr[i] = mx;
            mx = Math.max(mx, temp);
        }
        return arr;
    }
}