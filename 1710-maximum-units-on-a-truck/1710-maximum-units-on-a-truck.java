class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<>(){
            @Override
            public int compare(int[] a, int[] b){
                return b[1] - a[1];
            }
        });
        
        int max = 0;
        for(int[] boxType : boxTypes){
            int count = Math.min(truckSize, boxType[0]);
            max += count * boxType[1];
            truckSize -= count;
            if(truckSize == 0)
                return max;
        }
        
        return max;
    }
}