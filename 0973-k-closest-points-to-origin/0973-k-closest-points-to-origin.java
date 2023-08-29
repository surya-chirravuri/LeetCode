class Solution {
    public int distanceFromOrigin(int[] point) {
        return point[1] * point[1] + point[0] * point[0];
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((int[] a, int[] b) -> {
            return distanceFromOrigin(b) - distanceFromOrigin(a);
        });
       
        for(int[] point : points) {
            if(maxHeap.size() == k) {
                if(distanceFromOrigin(maxHeap.peek()) > distanceFromOrigin(point)) {
                    maxHeap.poll();
                    maxHeap.offer(point);
                }
            } else {
                maxHeap.offer(point);
            }
        }
        int[][] res = new int[k][2];
        while(--k >= 0) {
            res[k] = maxHeap.poll();
        }
        
        return res;
    }
}