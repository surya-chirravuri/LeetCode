class Solution {
public:
    int lengthOfLongestSubstringTwoDistinct(string s) {
        unordered_map<char,int> frequency;
        int len = 0, start = 0, end = 0;
       for(; end < s.size(); end++) {
           frequency[s[end]]++;
           while(frequency.size() > 2) {
               frequency[s[start]]--;
               if(frequency[s[start]] == 0) frequency.erase(s[start]);
               start++;
           }
           len = max(len, end-start+1);
       }
        return len;
    }
};