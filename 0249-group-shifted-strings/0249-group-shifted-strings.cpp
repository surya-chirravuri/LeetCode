class Solution {
public:
    string computeDifference(string s) {
        string res = "";
        for(int i = 1; i < s.size(); i ++) {
            int diff = (s[i] - s[i-1] + 26) % 26;
            res += to_string(diff) + " ";
        }
        return res;
    }
    vector<vector<string>> groupStrings(vector<string>& strings) {
        unordered_map<string, vector<string>> shifted;
        for(auto str: strings) {
            shifted[computeDifference(str)].push_back(str);
        }
        vector<vector<string>> result;
        for(auto entry: shifted){
            result.push_back(entry.second);
        }
        return result;
    }
};