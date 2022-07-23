class Solution {
    public int findUnsortedSubarray(int[] array) {
        int start = -1, end = -1;
        int max = array[0], min = array[array.length-1];

        for(int i = 1; i < array.length; ++i){
          if(array[i] < max){
            end = i;
          }
          max = Math.max(max, array[i]);

        }

        for(int i = array.length - 2; i>= 0; --i){
        if(array[i] > min){
            start = i;
        }
          min = Math.min(min, array[i]);
        }
        
        if(end == start)
            return 0;
        return end - start + 1;
    }
}