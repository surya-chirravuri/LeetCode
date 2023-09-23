class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        int len = 0, count = 0, start = 0, end = 0;
        for(;end < nums.size(); end++) {
            count += !nums[end];
            while(count > k) {
                count -= !nums[start++];
            }
            len = max(len, end - start + 1);
        }
        return len;
    }
};