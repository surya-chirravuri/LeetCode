class Solution {
public:
    bool checkSubarraySum(vector<int>& nums, int k) {
        unordered_map<int, int> remMap;
        int count = 0;
        int sum = 0;
        int rem = 0;
        for(int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            int rem = sum % k;
            if((remMap.find(rem) != remMap.end() && i - remMap[rem] >= 2|| !rem && i != 0)) 
                return true;
            remMap[rem] = remMap.find(rem) == remMap.end() ? i : remMap[rem];
        }
        return false;
    }
};