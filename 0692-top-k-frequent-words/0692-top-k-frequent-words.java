class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequency = new HashMap<>();
        PriorityQueue<String> minHeap = new PriorityQueue<>(k, (String a, String b) -> frequency.get(a) == frequency.get(b) ? b.compareTo(a) : frequency.get(a) - frequency.get(b));
        
        for(String word: words) {
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }
        
        for(Map.Entry<String, Integer> entry: frequency.entrySet()) {
            // System.out.println(entry.getKey()+ " " + entry.getValue());
            minHeap.offer(entry.getKey());
            if(minHeap.size() > k ) {
                 minHeap.poll();
            }
        }
        
        int n  = words.length;
        List<String> result = Arrays.asList(new String[k]);
        int position = k-1;
        
        while(!minHeap.isEmpty()) {
            result.set(position--, minHeap.poll());    
        }
        
        return result;
    }
}