class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int, int> countSum;
        int sum = 0;
        int count = 0;
        countSum[0] = 1;
        for(auto num: nums) {
            sum += num;
            count += (countSum[sum - k] );
            countSum[sum]++;
        }
        return count;
    }
};