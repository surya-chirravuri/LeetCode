class Solution {
public:
    bool arrayStringsAreEqual(vector<string>& word1, vector<string>& word2) {
        auto concat = [](const vector<string>& words) {
            return accumulate(words.begin(), words.end(), string(""));
        };
        
        return concat(word1) == concat(word2);
    }
};