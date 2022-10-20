class Solution {
    public String intToRoman(int num) {
        /*  
            Greedy Approach: Initialize two arrays with all possible roman string andnumber combinations in descending order. 
            Following are the legitamate possible roman symbols and number combinations.  
        */
        String [] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        Integer [] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int i = 0;
        StringBuilder result = new StringBuilder();
        
         /*
            Our goal is to check how many times each number is divisible by the roman symbols
            and convert the number to roman symbol greedily. 
            
            Example :3888
            We start with 1000 and check if the given number is greater than 1000. In this case, it is
            we need to know exactly how many times the number is divisible by 1000 because we need to replace 1000 with M that many number of times.
            
            So we know 3000 can be represented with 3 Ms (MMM) as floor(3888 / 1000) is 3.
            Now since we have converted 3000 to roman number, we need to convert the reminder ie 888.
            
            We know for sure the reminder from the previous operation is less than the previous divisor, 
            so we don't have to loop through the numbers array from the start every time. 
            We can start traversing nums array with the index after the previous divisor, as it is sorted in descending order.
            
            888 < 900, so we continue traversing the nums array. the next element in the array is 500. 888 > 500, so we break out of the first for loop             below. Now 888 / 500 = 1 so we append the roman notation for 1 500 i.e D to our result.
            
            Now the result so far is MMMD and reminder is 388.

            After solving for the reminder in the similar manner, we get the answer MMMMDCCCLXXXVIII.
            
            Time Complexity: O(1)
            Space Complexity: O(1)
            
            This is because we use two arrays of fixed size 13 to store the roman and binary numbers. And no matter what the number is we know 
            the below operations are in the worst case constant space as array size is constant and we are just iterating a constant sized array and we             can guarantee in the work case iterates through every element at the most once. The divisorcan at the most be O(8) which is constant. And               all the operations in the below loop are constant operations.  

        */
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