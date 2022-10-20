class Solution {
public:
    string intToRoman(int num) {
        vector<pair<int,string>> romanPairs = {
            {1000, "M"}, {900, "CM"}, {500, "D"}, {400, "CD"}, {100, "C"}, {90, "XC"}, 
            {50, "L"}, {40, "XL"}, {10, "X"}, {9, "IX"}, {5, "V"}, {4, "IV"}, {1, "I"}
        };
        
        int i = 0;
        string result = "";
        
        while(num > 0) {
            for(;num < romanPairs[i].first; i++);
            string roman = romanPairs[i].second;
            int number = romanPairs[i].first; 
            int count = (num / number);
            
            for(int j = 0; j < count; j++)
                result += roman;
            num = num - count * number;
        }
        
        return result;
    }
};