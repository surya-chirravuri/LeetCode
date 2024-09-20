class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length -1;
        int mid;
        
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(mid + 1 < nums.length && mid - 1 >= 0 && nums[mid + 1] > nums[mid] && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if(nums[mid] < nums[right]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return right >= 0 ? nums[right] : nums[0];
    }
}