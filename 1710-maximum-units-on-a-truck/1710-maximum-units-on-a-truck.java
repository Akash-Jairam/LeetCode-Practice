class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] count = new int[1001];
        int max = 0;
        for(int[] box : boxTypes){
            count[box[1]] += box[0];
        }
        
        for(int i = 1000; i >= 0; --i){
            if(count[i] > 0){
                int num = Math.min(count[i], truckSize);
                max += i * num;
                truckSize -= num;
                if(truckSize == 0)
                    return max;
            }
        }
        
        return max;
    }
}