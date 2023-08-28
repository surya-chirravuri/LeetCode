class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        for(int num: nums) {
            if(minHeap.size() < k) {
               minHeap.offer(num);
            }
            else if(num > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }
        int res = minHeap.peek();
        
        // while (!minHeap.isEmpty()) {
        //     System.out.print(minHeap.poll() + " ");
        // }
        
        return res;
    }
}