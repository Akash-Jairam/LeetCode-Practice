class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3)
            return false;
        int peak = -1;
        int i = 0;
        
        for(int j = 1; j < arr.length; j++){
            if(peak != -1){
                if(arr[i] > arr[j]){
                    i++;
                } else
                    return false;
            } else{
                if(arr[i] < arr[j]){
                    i++;
                } else if(arr[i] > arr[j] && i > 0) {
                    peak = arr[i];
                    i++;
                } else{
                    return false;
                }
            }
        }
        if(peak != -1)
            return true;
        
        return false;
    }
}