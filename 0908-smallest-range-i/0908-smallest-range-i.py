class Solution:
    def smallestRangeI(self, nums: List[int], k: int) -> int:
        min_n, max_n = min(nums), max(nums)
        return 0 if min_n + k >= max_n - k else max_n - min_n - 2 * k