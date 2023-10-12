class Solution {
public:
    int calculate(string s) {
        int len = s.length();
        int num = 0;
        s+= '+';
        stack<int> numbers;
        char sign = '+';
        for(int i = 0; i < s.size(); i++) {
            if(isdigit(s[i])) num = num * 10 + (s[i] - '0');
            if(!isdigit(s[i]) && s[i] != ' ') {
                if(sign == '+') {
                    numbers.push(num);
                } else if(sign == '-') {
                    numbers.push(num * (-1));
                } else if(sign == '*') {
                    int stackTop = numbers.top(); 
                    numbers.pop();
                    numbers.push(stackTop * num);
                } else {
                    int stackTop = numbers.top(); 
                    numbers.pop();
                    numbers.push(stackTop / num);
                }
                sign = s[i];
                num = 0;
            }
        }
        int result = 0;
        while(!numbers.empty()){
            result += numbers.top();
            numbers.pop();
        }
        return result;
    }
};