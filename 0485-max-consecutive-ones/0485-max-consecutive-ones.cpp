class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int len = 0 , count = 0;
        for(auto num: nums) {
            count = num ? count + 1 : 0;
            len = max(count, len);
        }
        return len;
    }
};