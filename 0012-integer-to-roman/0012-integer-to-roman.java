class Solution {
    public String intToRoman(int num) {
        String [] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        Integer [] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        int i = 0;
        StringBuilder result = new StringBuilder();
        while(num > 0) {
            for(;num < nums[i]; i++);
            int count = (num / nums[i]);
            for(int j = 0; j < count; j++)
                result.append(romans[i]);
            num = num - count * nums[i];
        }
        
        return result.toString();
    }
}