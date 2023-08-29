class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((int[] a, int[] b) -> {
            return (b[1] * b[1] + b[0] * b[0]) - (a[1] * a[1] + a[0] * a[0]);
        });
       
        for(int[] point : points) {
            maxHeap.offer(point);
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[][] res = new int[k][2];
        while(--k >= 0) {
            res[k] = maxHeap.poll();
        }
        
        return res;
    }
}