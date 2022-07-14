class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
      if(nums2.length > nums1.length)
          return intersect(nums2, nums1);
        
      HashMap<Integer, Integer> map = new HashMap<>();
      for(int num : nums1){
          map.put(num, map.getOrDefault(num, 0) + 1);
      }
      
      int idx = 0;
      for(int num : nums2){
          int count = map.getOrDefault(num, 0);
          if(count > 0){
              nums1[idx] = num;
              ++idx;
              map.put(num, count - 1);
          }
      }
        
      return Arrays.copyOfRange(nums1, 0, idx);
    }
}