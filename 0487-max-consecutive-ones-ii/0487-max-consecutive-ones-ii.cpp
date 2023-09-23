class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int len = 0, count = 0, start = 0, end = 0;
        for(;end < nums.size(); end++) {
            count += !nums[end];
            while(count > 1) {
                count -= !nums[start++];
            }
            len = max(len, end - start + 1);
        }
        return len;
    }
};