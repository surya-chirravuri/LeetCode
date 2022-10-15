class Solution {
    public int countTime(String time) {
        int[] maxPossibleValues = {3, 10, 0, 6, 10};
        int result = 1;
        for(int i = 0; i < 5; i++) {
            if(i == 2) {
                result = Math.min(result, 24);
            } 
          
            else if(i == 0 && time.charAt(i+1) >= '4' && time.charAt(i+1) <= '9' && time.charAt(i) == '?') {
                result *= maxPossibleValues[i] - 1;
            }
            
            else if(i == 1 && time.charAt(i) == '?' && time.charAt(i-1) == '2') {
                 result *= 4;
            } 
            
            else if(time.charAt(i) == '?') {
                result *= maxPossibleValues[i];
            }
        }
        return result;
    }
}