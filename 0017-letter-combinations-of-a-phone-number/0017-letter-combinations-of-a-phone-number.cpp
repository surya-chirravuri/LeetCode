class Solution {
public:
    void getCombinations(string digits, int index, string combination, vector<string> &combinations, const vector<string>& letters) {
        if(index == digits.size()) {
            if(!combination.empty())
                combinations.push_back(combination);
            return;
        }
        for(auto letter: letters[digits[index] - '0']) {
            getCombinations(digits, index + 1, combination + letter, combinations, letters);
        }
    }
    
    vector<string> letterCombinations(string digits) {
        vector<string> result;
        vector<string> letters = { "", "" , "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        getCombinations(digits, 0, "", result, letters);
        return result;
    }
};