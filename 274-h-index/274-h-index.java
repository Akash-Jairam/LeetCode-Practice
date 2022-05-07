class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        
        int lo = 0;
        int hi = citations.length - 1;
        int index = 0;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(citations[mid] == citations.length - mid){
                return citations[mid];
            } else if(citations[mid] > citations.length - mid){
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        return citations.length - lo;
    }
}