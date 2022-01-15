class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = nums1.length -1;
        int lastIndexOfNums1 = m-1;
        int lastIndexOfNums2 = n-1;
        
        while(k > 0 && lastIndexOfNums1 >= 0 && lastIndexOfNums2 >=0 ){
            if(nums1[lastIndexOfNums1] > nums2[lastIndexOfNums2]){
                nums1[k] = nums1[lastIndexOfNums1];
                lastIndexOfNums1--;
            } else{
                nums1[k] = nums2[lastIndexOfNums2];
                lastIndexOfNums2--;
            }
            k--;
        }
        
        if(lastIndexOfNums2 >=0){
            for(int i = 0; i <= k; i++){
                nums1[i] = nums2[i];
            }
        } 
    }
}