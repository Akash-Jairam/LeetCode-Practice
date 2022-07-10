class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return intersection(nums2, nums1);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int idx = 0;
        
        for(int num : nums2){
            int count = map.getOrDefault(num,0);
            if(count > 0){
                nums1[idx] = num;
                map.put(num, 0);
                ++idx;
            }
        }
        
        return Arrays.copyOfRange(nums1, 0, idx);
    }
}