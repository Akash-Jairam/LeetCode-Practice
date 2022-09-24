class Solution {
    public int[] amountPainted(int[][] paint) {
        if(paint == null || paint.length == 0) return new int[]{};
        int[] canvas = new int[50001];
        int[] res = new int[paint.length];
        
        for(int i = 0; i < paint.length; ++i){
            int start = paint[i][0];
            int end = paint[i][1];
            
            while(start < end){
                int next = Math.max(start + 1, canvas[start]);
                res[i] += canvas[start] == 0 ? 1 : 0;
                canvas[start] = Math.max(canvas[start], end);
                start = next;
            }
        }
        
        return res;
    }
}