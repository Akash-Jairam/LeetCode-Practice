class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (x, y) -> (y[1] - x[1]));
        int max = 0;
        
        for(int[] box : boxTypes){
            int units = truckSize - box[0] > 0 ? box[0] : truckSize;
            max += box[1] * units;
            truckSize -= units;
            if(truckSize == 0)
                break;
        }
        
        return max;
    }
}