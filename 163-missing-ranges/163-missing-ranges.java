class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();            
        List<Integer> missing = new ArrayList<>();
        if(nums == null || nums.length == 0){
            if(lower != upper){
                missing.add(lower);
                missing.add(upper);
            } else
                missing.add(lower);
            
            addRange(res, missing);
            return res;
        }

        int idx = 0;
        boolean emptyMissing = false;
        while(lower <= upper){
            if(lower != nums[idx]){
                if(lower < nums[idx]){
                    missing.add(lower);
                    if(lower != nums[idx] - 1)
                        missing.add(nums[idx] - 1);
                    lower = nums[idx] + 1;
                    if(idx < nums.length - 1)
                        ++idx;
                    
                } else {
                    if(nums[idx] + 1 != upper){
                    missing.add(nums[idx] + 1);
                    missing.add(upper);
                    } else {
                        missing.add(upper);
                    }
                    lower = upper+1;
                }
                addRange(res, missing);
                missing = new ArrayList<>();
            } else {
                lower++;
                if(idx < nums.length -1)
                    ++idx;
            }
        }
        if(emptyMissing)
            addRange(res, missing);
        return res;
    }
    
    public void addRange(List<String> res, List<Integer> missing){
        if(missing.size() > 1){
                    res.add(String.valueOf(missing.get(0)) + "->" + String.valueOf(missing.get(missing.size() - 1)));
        } else if(missing.size() == 1){
                    res.add(String.valueOf(missing.get(0)));
        }
    }
}