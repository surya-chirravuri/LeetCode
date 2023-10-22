class Solution {
public:
    string computeDifference(string s) {
        string res = "";
        for(int i = 1; i < s.size(); i ++) {
            int diff = s[i] - s[i-1];
            res += to_string(diff < 0 ? (diff + 26) : diff) + " ";
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
            // cout<<entry.first <<" "<<"[";
            // for(auto s: entry.second) {
            //     cout<<s<<",";
            // }
            // cout<<"]"<<endl;
            result.push_back(entry.second);
        }
        return result;
    }
};